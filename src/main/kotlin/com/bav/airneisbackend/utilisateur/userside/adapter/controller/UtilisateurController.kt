package com.bav.airneisbackend.utilisateur.userside.adapter.controller

import com.bav.airneisbackend.utilisateur.domain.usecase.AjoutArticleDansLePanier
import com.bav.airneisbackend.utilisateur.domain.usecase.ModifierPanier
import com.bav.airneisbackend.utilisateur.domain.usecase.RecuperUtilisateur
import com.bav.airneisbackend.utilisateur.domain.usecase.SupprimerArticleDansPanier
import com.bav.airneisbackend.utilisateur.userside.adapter.controller.documentation.UtilisateurControllerDocumentation
import com.bav.airneisbackend.utilisateur.userside.mapper.UtilisateurMapper.toPanier
import com.bav.airneisbackend.utilisateur.userside.mapper.UtilisateurMapper.toUtilisateurRestRessource
import com.bav.airneisbackend.utilisateur.userside.restressource.PanierRestRessource
import com.bav.airneisbackend.utilisateur.userside.restressource.SuppressionArticleDansPanierRestRessource
import com.bav.airneisbackend.utilisateur.userside.restressource.UtilisateurRestRessource
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/utilisateur")
class UtilisateurController(
    val ajoutArticleDansLePanier: AjoutArticleDansLePanier,
    val supprimerUnArticleDansPanier: SupprimerArticleDansPanier,
    val recuperUtilisateur: RecuperUtilisateur,
    val modifierPanier: ModifierPanier
) : UtilisateurControllerDocumentation {

    @GetMapping("/me")
    override fun utilisateurActuel(): ResponseEntity<UtilisateurRestRessource> {
        val user = recuperUtilisateur()
        return ResponseEntity.ok().body(user.toUtilisateurRestRessource())

    }

    @PutMapping("/panier")
    override fun ajouterArticleDansPanier(@RequestParam("idArticle")idArticle: String,@RequestParam("quantite", defaultValue = "1") quantite:  Int): ResponseEntity<UtilisateurRestRessource> {
        val ajouterArticleDansPanierUtilisateurServerSidePort = ajoutArticleDansLePanier(idArticle, quantite)
        return ResponseEntity.ok(ajouterArticleDansPanierUtilisateurServerSidePort.toUtilisateurRestRessource())
    }

    @DeleteMapping("/panier/article/{idArticle}")
    override fun supprimerArticleDansPanier(@PathVariable idArticle: String): ResponseEntity<SuppressionArticleDansPanierRestRessource> {
        val produitSupprime = supprimerUnArticleDansPanier(idArticle)
        return ResponseEntity.ok(SuppressionArticleDansPanierRestRessource("L'article a été supprimé du panier avec succès", produitSupprime))
    }


    @PatchMapping("/panier")
    override fun modifierPanier(@RequestBody panier: PanierRestRessource): ResponseEntity<UtilisateurRestRessource> {
        val utilisateur = modifierPanier(panier.toPanier())
        return ResponseEntity.ok(utilisateur.toUtilisateurRestRessource())
    }


}