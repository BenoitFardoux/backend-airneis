package com.bav.airneisbackend.categorie.userside.adaptater.controller.documentation

import com.bav.airneisbackend.categorie.userside.dto.CategorieRestRessource
import com.bav.airneisbackend.categorie.userside.dto.PourCreerCategorieRestRessource
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.hateoas.CollectionModel
import org.springframework.http.ResponseEntity

interface CategorieControllerDocumentation {
    @Operation(
        summary = "Récuperer l'ensemble des categories",
        description = "Recuperer l'ensemble des categories"
    )
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200",
                description = "L'ensemble des categories"
            )
        ]
    )
    fun recupererCategories(
        pageNumber: Int,
        pageSize: Int
    ): ResponseEntity<CollectionModel<CategorieRestRessource>>

    @Operation(
        summary = "Récuperer une categorie par son id",
        description = "Recuperer une categorie par son id"
    )
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200",
                description = "La categorie"
            )
        ]
    )
    fun recupererCategorieParId(id: String): ResponseEntity<CategorieRestRessource>

    @Operation(
        summary = "Persiste une categorie",
        description = "Persiste une categorie persite une categorie en base de donnée"
    )
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "201",
                description = "La categorie a été créé"
            )
        ]
    )
    fun creerCategorie(categorieRestRessource: PourCreerCategorieRestRessource): ResponseEntity<CategorieRestRessource>
}