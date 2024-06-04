package com.bav.airneisbackend.utilisateur.userside.adapter.controller.utilisateur

import com.bav.airneisbackend.utilisateur.domain.model.Utilisateur
import com.bav.airneisbackend.utilisateur.domain.usecase.utilisateur.CommanderPanier
import com.bav.airneisbackend.utilisateur.domain.usecase.utilisateur.ModifierMoyensMoyensDePaiement
import com.bav.airneisbackend.utilisateur.domain.usecase.utilisateur.RecuperUtilisateur
import com.bav.airneisbackend.utilisateur.userside.adapter.controller.utilisateur.documentation.UtilisateurControllerDocumentation
import com.bav.airneisbackend.utilisateur.userside.mapper.PaiementsMapper.toPaiements
import com.bav.airneisbackend.utilisateur.userside.mapper.UtilisateurMapper.toUtilisateurRestRessource
import com.bav.airneisbackend.utilisateur.userside.restressource.FacturationRestRessource
import com.bav.airneisbackend.utilisateur.userside.restressource.MoyensDePaiementUtilisateursRestRessource
import com.bav.airneisbackend.utilisateur.userside.restressource.UtilisateurRestRessource
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@SecurityRequirement(name = "Bearer Authentication")
@RequestMapping("/utilisateur")
class UtilisateurController(
    val recuperUtilisateur: RecuperUtilisateur,
    val modifierMoyensMoyensDePaiement: ModifierMoyensMoyensDePaiement,
    val commanderPanierUtilisateur: CommanderPanier
) : UtilisateurControllerDocumentation {

    @GetMapping("/me")
    override fun utilisateurActuel(): ResponseEntity<UtilisateurRestRessource> {
        val user = recuperUtilisateur()
        return ResponseEntity.ok().body(user.toUtilisateurRestRessource())

    }


    @PatchMapping("/moyens-de-paiements")
    override fun modifierMoyensDePaiements(@RequestBody moyensDePaiementUtilisateursRestRessource: MoyensDePaiementUtilisateursRestRessource): ResponseEntity<UtilisateurRestRessource> {
        val paiement = moyensDePaiementUtilisateursRestRessource.toPaiements()
        val utilisateur = modifierMoyensMoyensDePaiement(paiement)
        return ResponseEntity.ok(utilisateur.toUtilisateurRestRessource())
    }


    @PatchMapping("/panier/commander/")
    override fun commanderPanier(@RequestBody facturationRestRessource: FacturationRestRessource): ResponseEntity<UtilisateurRestRessource> {
        val utilisateur : Utilisateur = commanderPanierUtilisateur(facturationRestRessource.adresse, facturationRestRessource.moyenDePaiement)
        return ResponseEntity.ok(utilisateur.toUtilisateurRestRessource())
    }

}