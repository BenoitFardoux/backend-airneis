package com.bav.airneisbackend.utilisateur.userside.adapter.controller.panier

import com.bav.airneisbackend.utilisateur.domain.usecase.panier.AjoutArticleDansLePanier
import com.bav.airneisbackend.utilisateur.domain.usecase.panier.ModifierPanier
import com.bav.airneisbackend.utilisateur.domain.usecase.panier.SupprimerArticleDansPanier
import com.bav.airneisbackend.utilisateur.userside.adapter.controller.panier.documentation.PanierControllerDocumentation
import com.bav.airneisbackend.utilisateur.userside.mapper.UtilisateurMapper.toPanier
import com.bav.airneisbackend.utilisateur.userside.mapper.UtilisateurMapper.toUtilisateurRestRessource
import com.bav.airneisbackend.utilisateur.userside.restressource.PanierRestRessource
import com.bav.airneisbackend.utilisateur.userside.restressource.SuppressionArticleDansPanierRestRessource
import com.bav.airneisbackend.utilisateur.userside.restressource.UtilisateurRestRessource
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/utilisateur")
@SecurityRequirement(name = "Bearer Authentication")
class PanierController(
    private val ajoutArticleDansLePanier: AjoutArticleDansLePanier,
    private val supprimerUnArticleDansPanier: SupprimerArticleDansPanier,
    private val modifierPanier: ModifierPanier
) : PanierControllerDocumentation {
    @PutMapping("/panier")
    override fun ajouterArticleDansPanier(
        @RequestParam("idArticle") idArticle: String, @RequestParam("quantite", defaultValue = "1") quantite: Int
    ): ResponseEntity<UtilisateurRestRessource> {
        val ajouterArticleDansPanierUtilisateurServerSidePort = ajoutArticleDansLePanier(idArticle, quantite)
        return ResponseEntity.ok(ajouterArticleDansPanierUtilisateurServerSidePort.toUtilisateurRestRessource())
    }

    @DeleteMapping("/panier/article/{idArticle}")
    override fun supprimerArticleDansPanier(@PathVariable idArticle: String): ResponseEntity<SuppressionArticleDansPanierRestRessource> {
        val produitSupprime = supprimerUnArticleDansPanier(idArticle)
        return ResponseEntity.ok(
            SuppressionArticleDansPanierRestRessource(
                "L'article a été supprimé du panier avec succès", produitSupprime
            )
        )
    }


    @PatchMapping("/panier")
    override fun modifierPanier(@RequestBody panier: PanierRestRessource): ResponseEntity<UtilisateurRestRessource> {
        val utilisateur = modifierPanier(panier.toPanier())
        return ResponseEntity.ok(utilisateur.toUtilisateurRestRessource())
    }


}