package com.bav.airneisbackend.utilisateur.userside.adapter.controller

import com.bav.airneisbackend.utilisateur.domain.usecase.SIncrire
import com.bav.airneisbackend.utilisateur.userside.adapter.controller.documentation.UtilisateurControllerDocumentation
import com.bav.airneisbackend.utilisateur.userside.dto.AuthenticationRequest
import com.bav.airneisbackend.utilisateur.userside.dto.AuthentificationResponse
import com.bav.airneisbackend.utilisateur.userside.dto.RequeteInscription
import com.bav.airneisbackend.utilisateur.userside.mapper.UtilisateurMapper.toUtilisateur
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
class UtilisateurController(
    val sinscrire: SIncrire,
) : UtilisateurControllerDocumentation {

    @PostMapping("/signup")
    override fun inscrire(@RequestBody requeteInscription: RequeteInscription): ResponseEntity<String> {
        val utilisateur = requeteInscription.toUtilisateur()
        sinscrire(utilisateur)
        return ResponseEntity.status(HttpStatus.CREATED).body("Utilisateur créé avec succès")
    }

    override fun authentifier(authenticationRequest: AuthenticationRequest): ResponseEntity<AuthentificationResponse> {
        TODO("Not yet implemented")
    }
}


