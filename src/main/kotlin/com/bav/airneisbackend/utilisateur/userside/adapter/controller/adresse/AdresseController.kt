package com.bav.airneisbackend.utilisateur.userside.adapter.controller.adresse

import com.bav.airneisbackend.utilisateur.domain.model.Adresse
import com.bav.airneisbackend.utilisateur.domain.usecase.adresse.AjouterUneAdresse
import com.bav.airneisbackend.utilisateur.domain.usecase.adresse.ModifierAdresses
import com.bav.airneisbackend.utilisateur.userside.adapter.controller.adresse.documentation.AdresseControllerDocumentation
import com.bav.airneisbackend.utilisateur.userside.mapper.UtilisateurMapper.toUtilisateurRestRessource
import com.bav.airneisbackend.utilisateur.userside.restressource.UtilisateurRestRessource
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController



@SecurityRequirement(name = "Bearer Authentication")
@RestController("/utilisateur/adresse")
class AdresseController(val modifierLesAdresses: ModifierAdresses, val ajouterUneAdresse: AjouterUneAdresse) : AdresseControllerDocumentation {
    @PatchMapping("/modifier")
    override fun modifierAdresses(@RequestBody adresses: List<Adresse>): ResponseEntity<UtilisateurRestRessource> =
         ResponseEntity.ok(modifierLesAdresses(adresses).toUtilisateurRestRessource())


    @PostMapping("/ajouter")
    override fun ajouterAdresse(@RequestBody adresse: Adresse): ResponseEntity<UtilisateurRestRessource> =
        ResponseEntity.status(HttpStatus.CREATED).body(ajouterUneAdresse(adresse).toUtilisateurRestRessource())



}