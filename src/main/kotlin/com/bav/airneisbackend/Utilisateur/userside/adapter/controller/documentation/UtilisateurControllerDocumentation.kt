package com.bav.airneisbackend.utilisateur.userside.adapter.controller.documentation

import com.bav.airneisbackend.utilisateur.userside.dto.AuthenticationRequest
import com.bav.airneisbackend.utilisateur.userside.dto.AuthentificationResponse
import com.bav.airneisbackend.utilisateur.userside.dto.RequeteInscription
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.http.ResponseEntity

interface UtilisateurControllerDocumentation {
    @Operation(
        summary = "Inscription",
        description = "Inscription d'un utilisateur"
    )
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "201",
                description = "L'utilisateur a été inscrit"
            )
        ]
    )
    fun inscrire(requeteInscription: RequeteInscription) : ResponseEntity<String>
    @Operation(
        summary = "Authentification",
        description = "Authentification d'un utilisateur"
    )
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200",
                description = "L'utilisateur a été authentifié"
            )
        ]
    )
    fun authentifier(authenticationRequest: AuthenticationRequest) : ResponseEntity<AuthentificationResponse>
}