package com.bav.airneisbackend.produit.userside.adaptater.controller

import com.bav.airneisbackend.produit.domain.usecase.RecupererProduits
import org.springframework.web.bind.annotation.RequestParam


import com.bav.airneisbackend.produit.userside.adaptater.controller.documentation.ProduitControllerDocumentation
import com.bav.airneisbackend.produit.userside.mapper.ProduitMapper
import com.bav.airneisbackend.produit.userside.restressources.ProduitRestRessource
import org.springframework.data.domain.PageRequest
import org.springframework.hateoas.CollectionModel
import org.springframework.hateoas.PagedModel
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


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
        pageSize: Int
    ): ResponseEntity<CollectionModel<ProduitRestRessource>> {
        val pageable = PageRequest.of(pageNumber, pageSize)
        val produitPage = recupererProduits(pageable)
        val produitRestRessource = ProduitMapper.mapProduitPageToProduitRestRessource(produitPage)
        val pagedModel = PagedModel.of(produitRestRessource)

        pagedModel.add(
            WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(ProduitController::class.java)
                    .recupererTousLesProduits(pageNumber, pageSize)
            ).withSelfRel()
        )

        return ResponseEntity.ok(pagedModel)
    }

}