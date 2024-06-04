package com.bav.airneisbackend.materiaux.userside.adaptater.controller.documentation

import com.bav.airneisbackend.materiaux.userside.restressources.MateriauRestRessource
import com.bav.airneisbackend.materiaux.userside.restressources.PourCreerMateriauRestRessource
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.hateoas.CollectionModel
import org.springframework.http.ResponseEntity

interface ReferentielDeMateriauxControllerDocumentation {
    @Operation(
        summary = "Récuperer l'ensemble des materiaux",
        description = "Recuperer l'ensemble des materiaux",
        security = [SecurityRequirement(name = "")]  // Indique qu'il n'y a pas de sécurité requise

    )
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200",
                description = "L'ensemble des materiau"
            ),
            ApiResponse(
                responseCode = "404",
                description = "Aucun materiau n'a été trouvé"
            )
        ]
    )
    fun recupererMateriaux(
        pageNumber: Int,
        pageSize: Int,
        critereDeRecherche: String?
    ): ResponseEntity<CollectionModel<MateriauRestRessource>>

    @Operation(
        summary = "Récuperer un materiau par son id",
        description = "Recuperer un materiau par son id",
        security = [SecurityRequirement(name = "")]  // Indique qu'il n'y a pas de sécurité requise

    )
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200",
                description = "Le materiau"
            ),
            ApiResponse(
                responseCode = "404",
                description = "Aucun materiau n'a été trouvé"
            )
        ]
    )
    fun recupererMateriauParId(id: String): ResponseEntity<MateriauRestRessource>


    @Operation(
        summary = "Persiste un materiau",
        description = "Persiste un materiau persite un materiau en base de donnée"
    )
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "201",
                description = "Le materiau a été persisté"
            ),
            ApiResponse(
                responseCode = "400",
                description = "Des informations sont manquante" ,
                useReturnTypeSchema = false
            )
        ]
    )
    fun persisteMateriau(materiau: PourCreerMateriauRestRessource): ResponseEntity<Any>
}