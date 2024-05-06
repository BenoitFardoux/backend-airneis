package com.bav.airneisbackend.Materiaux.userside.adaptater.controller.documentation

import com.bav.airneisbackend.Materiaux.userside.restressources.MateriauRestRessource
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.hateoas.CollectionModel
import org.springframework.http.ResponseEntity

interface ReferentielDeMateriauxControllerDocumentation {
    @Operation(
        summary = "Récuperer l'ensemble des materiaux",
        description = "Recuperer l'ensemble des materiaux"
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
}