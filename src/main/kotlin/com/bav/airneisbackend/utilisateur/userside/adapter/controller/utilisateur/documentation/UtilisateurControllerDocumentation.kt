package com.bav.airneisbackend.utilisateur.userside.adapter.controller.utilisateur.documentation

import com.bav.airneisbackend.utilisateur.userside.restressource.FacturationRestRessource
import com.bav.airneisbackend.utilisateur.userside.restressource.MoyensDePaiementUtilisateursRestRessource
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




    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200",
                description = "Les moyens de paiements on été modifiés avec succès"
            )
        ]
    )
    @Operation(
        summary = "Modifier les moyens de paiements",
        description = "Modifie les moyens de paiements de l'utilisateur actuel"
    )
    fun modifierMoyensDePaiements(moyensDePaiementUtilisateursRestRessource: MoyensDePaiementUtilisateursRestRessource) : ResponseEntity<UtilisateurRestRessource>


    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200",
                description = "Le panier a été commandé avec succès"
            )
        ]
    )
    @Operation(
        summary = "Commander le panier",
        description = "Commande le panier de l'utilisateur actuel"
    )
    fun commanderPanier(facturationRestRessource: FacturationRestRessource) : ResponseEntity<UtilisateurRestRessource>
}