package com.bav.airneisbackend.categorie.userside.adaptater.controller.documentation

import com.bav.airneisbackend.categorie.userside.dto.CategorieRestRessource
import com.bav.airneisbackend.categorie.userside.dto.PourCreerCategorieRestRessource
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.http.ResponseEntity

interface CategorieControllerDocumentation {

    @Operation(
        summary = "Récuperer une categorie par son id",
        description = "Recuperer une categorie par son id",
        security = [SecurityRequirement(name = "")]
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
        summary = "recupère toute les categories",
        description = "Recupère toute les categories",
    )
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200",
                description = "Les categories"
            )
        ]
    )
    fun recupererToutesLesCategories(): ResponseEntity<List<CategorieRestRessource>>

    @Operation(
        summary = "Persiste une categorie",
        description = "Persiste une categorie persite une categorie en base de donnée",
        security = [SecurityRequirement(name = "")]  // Indique qu'il n'y a pas de sécurité requise

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