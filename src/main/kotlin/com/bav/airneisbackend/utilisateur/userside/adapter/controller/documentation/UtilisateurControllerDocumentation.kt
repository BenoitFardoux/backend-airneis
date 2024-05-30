package com.bav.airneisbackend.utilisateur.userside.adapter.controller.documentation

import com.bav.airneisbackend.utilisateur.userside.restressource.SuppressionArticleDansPanierRestRessource
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
                description = "L'article a été ajouté dans le panier avec succès"
            )
        ]
    )
    @Operation(
        summary = "Ajouter un article dans le panier",
        description = "Ajoute un article dans le panier de l'utilisateur actuel"
    )
    fun ajouterArticleDansPanier(idArticle: String, quantite : Int) : ResponseEntity<UtilisateurRestRessource>


    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200",
                description = "L'article a été supprimé du panier avec succès"
            )
        ]
    )
    @Operation(
        summary = "Supprimer un article du panier",
        description = "Supprime un article du panier de l'utilisateur actuel"
    )
    fun supprimerArticleDansPanier(idArticle: String) : ResponseEntity<SuppressionArticleDansPanierRestRessource>
}