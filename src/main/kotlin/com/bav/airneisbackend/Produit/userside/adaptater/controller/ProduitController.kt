package com.bav.airneisbackend.Produit.userside.adaptater.controller

import com.bav.airneisbackend.Materiaux.domain.exception.AucunMateriauTrouveException
import com.bav.airneisbackend.Produit.domain.exception.AucunProduitTrouveException
import com.bav.airneisbackend.Produit.domain.usecase.RecupererProduits
import org.springframework.web.bind.annotation.RequestParam


import com.bav.airneisbackend.Produit.userside.adaptater.controller.documentation.ProduitControllerDocumentation
import com.bav.airneisbackend.Produit.userside.mapper.ProduitMapper
import com.bav.airneisbackend.Produit.userside.restressources.ProduitRestRessource
import org.springdoc.api.ErrorMessage
import org.springframework.data.domain.PageRequest
import org.springframework.hateoas.CollectionModel
import org.springframework.hateoas.PagedModel
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.lang.Exception


@RestController
@RequestMapping("/airneis/produits")
class ProduitController(
    private val recupererProduits: RecupererProduits
) : ProduitControllerDocumentation {

    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    override fun recupererTousLesProduits(
        @RequestParam("pageNumber", defaultValue = "0")
        pageNumber: Int ,
        @RequestParam("pageSize", defaultValue = "10")
        pageSize: Int,
        @RequestParam("critereDeRecherche")
        critere : String?
    ): ResponseEntity<CollectionModel<ProduitRestRessource>> {
        val pageable = PageRequest.of(pageNumber, pageSize)
        val produitPage = recupererProduits(pageable, critere)

        if (produitPage.isEmpty) {
            return ResponseEntity.notFound().build()
        }

        val produitRestRessource = ProduitMapper.mapProduitPageToProduitRestRessource(produitPage)
        val pagedModel = PagedModel.of(produitRestRessource)

        pagedModel.add(
            WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(ProduitController::class.java)
                    .recupererTousLesProduits(pageNumber, pageSize,critere)
            ).withSelfRel()
        )

        return ResponseEntity.ok(pagedModel)
    }

}