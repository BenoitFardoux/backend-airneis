package com.bav.airneisbackend.utilisateur.userside.adapter.controller.authentification.documentation

import com.bav.airneisbackend.utilisateur.domain.model.Utilisateur
import com.bav.airneisbackend.utilisateur.userside.restressource.ConnexionUtilisateurRestRessource
import com.bav.airneisbackend.utilisateur.userside.restressource.InscriptionUtilisateurRestRessource
import com.bav.airneisbackend.utilisateur.userside.restressource.LoginResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.http.ResponseEntity

interface AuthControllerDocumentation {
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200",
                description = "La clé api permettant de se connecter"
            )
        ]
    )
    @Operation(
        summary = "Se connecter à l'api",
        description = "renvoie une clé api",
        security = [SecurityRequirement(name = "")]  // Indique qu'il n'y a pas de sécurité requise

    )
    fun connexion(connexionUtilisateurRestRessource: ConnexionUtilisateurRestRessource) : ResponseEntity<LoginResponse>

    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200",
                description = "L'utilisateur"
            )
        ]
    )
    @Operation(
        summary = "Inscription d'un utilisateur",
        description = "Inscription d'un utilisateur",
        security = [SecurityRequirement(name = "")]  // Indique qu'il n'y a pas de sécurité requise

    )
    fun inscription(inscriptionUtilisateurRestRessource: InscriptionUtilisateurRestRessource) : ResponseEntity<Utilisateur>
}