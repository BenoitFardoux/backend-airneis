package com.bav.airneisbackend.Produit.userside.adaptater.controller

import com.bav.airneisbackend.Produit.domain.usecase.RecupererProduits
import com.bav.airneisbackend.Produit.domain.usecase.RecupererUnProduit
import org.springframework.web.bind.annotation.RequestParam


import com.bav.airneisbackend.Produit.userside.adaptater.controller.documentation.ProduitControllerDocumentation
import com.bav.airneisbackend.Produit.userside.mapper.ProduitMapper
import com.bav.airneisbackend.Produit.userside.restressources.ProduitRestRessource
import org.springframework.data.domain.PageRequest
import org.springframework.hateoas.CollectionModel
import org.springframework.hateoas.PagedModel
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/airneis/produits")
class ProduitController(
    private val recupererProduits: RecupererProduits,
    private val recupererUnProduit: RecupererUnProduit
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



    @GetMapping("/{id}", produces = [MediaType.APPLICATION_JSON_VALUE])
    override fun recupererProduitParId(@PathVariable id: String): ResponseEntity<ProduitRestRessource> {
        val materiau = recupererUnProduit(id)

        val materiauRestRessource = ProduitMapper.mapProduitToProduitRestRessource(materiau)
        return ResponseEntity.ok(materiauRestRessource)
    }

    @PostMapping
    override fun creerUnProduit(): ResponseEntity<ProduitRestRessource> {
        TODO("Not yet implemented")
    }

}