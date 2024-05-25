package com.bav.airneisbackend.utilisateur.userside.adapter.controller.documentation

import com.bav.airneisbackend.utilisateur.domain.model.Utilisateur
import com.bav.airneisbackend.utilisateur.userside.restressource.ConnexionUtilisateurRestRessource
import com.bav.airneisbackend.utilisateur.userside.restressource.InscriptionUtilisateurRestRessource
import com.bav.airneisbackend.utilisateur.userside.restressource.LoginResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.http.ResponseEntity

interface UtilisateurControllerDocumentation {
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200",
                description = "L'ensemble des utilisateurs"
            ),
            ApiResponse(
                responseCode = "403",
                description = "l'adresse mail ou le mot de passe est invalide"
            )
        ]
    )
    @Operation(
        summary = "Récuperer l'ensemble des utilisateurs",
        description = "Recuperer l'ensemble des utilisateurs"
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
        description = "Inscription d'un utilisateur"
    )
    fun inscription(inscriptionUtilisateurRestRessource: InscriptionUtilisateurRestRessource) : ResponseEntity<Utilisateur>
}