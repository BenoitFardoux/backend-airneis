package com.bav.airneisbackend.Produit.userside.adaptater.controller.documentation

import com.bav.airneisbackend.Produit.userside.restressources.ProduitRestRessource
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.hateoas.CollectionModel
import org.springframework.http.ResponseEntity

interface ProduitControllerDocumentation {
    @Operation(
        summary = "Récuperer l'ensemble des produits",
        description = "Recuperer l'ensemble des produits"
    )
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200",
                description = "L'ensemble des produits"
            )
        ]
    )
    fun recupererTousLesProduits(
        pageNumber: Int,
        pageSize: Int,
        critere : String?
        ) : ResponseEntity<CollectionModel<ProduitRestRessource>>

    @Operation(
        summary = "Récuperer un produit par son identifiant",
        description = "Recuperer un produit par son identifiant"
    )
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200",
                description = "Le produit"
            ),
            ApiResponse(
                responseCode = "404",
                description = "Le produit n'a pas été trouvé"
            )
        ]
    )
    fun recupererProduitParId(
        id: String
    ) : ResponseEntity<ProduitRestRessource>

    @Operation(
        summary = "Créer un produit",
        description = "Créer un produit"
    )
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "201",
                description = "Le produit a été créé"
            ),
            ApiResponse(
                responseCode = "400",
                description = "Les données du produit ne sont pas valides"
            )
        ]
    )
    fun creerUnProduit() : ResponseEntity<ProduitRestRessource>
}