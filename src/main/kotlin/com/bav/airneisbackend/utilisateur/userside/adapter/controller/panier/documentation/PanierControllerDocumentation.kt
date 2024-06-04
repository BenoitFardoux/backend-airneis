package com.bav.airneisbackend.utilisateur.userside.adapter.controller.panier.documentation

import com.bav.airneisbackend.utilisateur.userside.restressource.PanierRestRessource
import com.bav.airneisbackend.utilisateur.userside.restressource.SuppressionArticleDansPanierRestRessource
import com.bav.airneisbackend.utilisateur.userside.restressource.UtilisateurRestRessource
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.http.ResponseEntity

interface PanierControllerDocumentation {
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



    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200",
                description = "Le panier a été modifié avec succès"
            )
        ]
    )
    @Operation(
        summary = "Modifier le panier",
        description = "Modifie le panier de l'utilisateur actuel"
    )
    fun modifierPanier(panier : PanierRestRessource) : ResponseEntity<UtilisateurRestRessource>

}