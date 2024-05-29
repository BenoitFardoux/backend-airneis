package com.bav.airneisbackend.utilisateur.userside.adapter.controller.documentation

import com.bav.airneisbackend.utilisateur.userside.restressource.UtilisateurRestRessource
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse

import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.http.ResponseEntity

interface UtilisateurControllerDocumentation {
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200",
                description = "L'utilisateur actuel a été récupéré avec succès"
            )
        ]
    )
    @Operation(
        summary = "Récuperer l'utilisateur actuel",
        description = "Renvoie l'utilisateur actuel"
    )
    fun utilisateurActuel() : ResponseEntity<UtilisateurRestRessource>
}