package com.bav.airneisbackend.utilisateur.userside.adapter.controller.adresse.documentation

import com.bav.airneisbackend.utilisateur.domain.model.Adresse
import com.bav.airneisbackend.utilisateur.userside.restressource.UtilisateurRestRessource
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.responses.ApiResponse
import org.springframework.http.ResponseEntity

interface AdresseControllerDocumentation {
    @Operation(
        summary = "Modifie les adresses de l'utilisateur actuel",
        description = "Modifie les adresses de l'utilisateur actuel"
    )
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200",
                description = "Les adresses de l'utilisateur ont été modifiées"
            )
        ]
    )
    fun modifierAdresses(adresses : List<Adresse>) : ResponseEntity<UtilisateurRestRessource>

    @Operation(
        summary = "Ajoute une adresse à l'utilisateur actuel",
        description = "Ajoute une adresse à l'utilisateur actuel"
    )
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200",
                description = "L'adresse a été ajoutée à l'utilisateur"
            )
        ]
    )
    fun ajouterAdresse(adresse : Adresse) : ResponseEntity<UtilisateurRestRessource>


    @Operation(
        summary = "Supprime une adresse de l'utilisateur actuel",
        description = "Supprime une adresse de l'utilisateur actuel"
    )
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200",
                description = "L'adresse a été supprimée de l'utilisateur"
            )
        ]
    )
     fun supprimerAdresse( adresse: Adresse): ResponseEntity<UtilisateurRestRessource>
}