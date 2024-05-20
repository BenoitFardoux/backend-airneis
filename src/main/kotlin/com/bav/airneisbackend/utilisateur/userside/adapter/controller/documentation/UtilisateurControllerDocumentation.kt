package com.bav.airneisbackend.utilisateur.userside.adapter.controller.documentation

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses

interface UtilisateurControllerDocumentation {
    @Operation(
        summary = "Se connecter à l'application",
        description = "Se connecter à l'application via une adresse mail et un mot de passe"
    )
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200",
                description = "L'utilisateur est connecté"
            )
        ]
    )
    fun seConnecter(email: String, password: String): String
}