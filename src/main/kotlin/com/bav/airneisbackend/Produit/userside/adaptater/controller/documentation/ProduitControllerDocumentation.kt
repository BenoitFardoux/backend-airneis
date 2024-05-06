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
            ),
            ApiResponse(
                responseCode = "404",
                description = "Aucun produit trouvé"
            )
        ]
    )
    fun recupererTousLesProduits(
        pageNumber: Int,
        pageSize: Int,
        ) : ResponseEntity<CollectionModel<ProduitRestRessource>>
}