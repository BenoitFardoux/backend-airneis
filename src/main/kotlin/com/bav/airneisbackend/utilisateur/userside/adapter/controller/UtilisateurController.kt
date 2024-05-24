package com.bav.airneisbackend.utilisateur.userside.adapter.controller

import com.bav.airneisbackend.utilisateur.domain.model.Utilisateur
import com.bav.airneisbackend.utilisateur.domain.usecase.ConnexionUtilisateur
import com.bav.airneisbackend.utilisateur.domain.usecase.InscriptionUtilisateur
import com.bav.airneisbackend.utilisateur.serverside.exception.MotDePasseInvalideException
import com.bav.airneisbackend.utilisateur.serverside.mapper.UtilisateurMapper.toUtilisateurDocument
import com.bav.airneisbackend.utilisateur.userside.adapter.controller.documentation.UtilisateurControllerDocumentation
import com.bav.airneisbackend.utilisateur.userside.mapper.UtilisateurMapper.toUtilisateur
import com.bav.airneisbackend.utilisateur.userside.restressource.ConnexionUtilisateurRestRessource
import com.bav.airneisbackend.utilisateur.userside.restressource.InscriptionUtilisateurRestRessource
import com.bav.airneisbackend.utilisateur.userside.restressource.LoginResponse
import com.bav.airneisbackend.utils.JwtService
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.http.ResponseEntity
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RequestMapping("/auth")
@RestController
class UtilisateurController
    (
    private val connexionUtilisateur: ConnexionUtilisateur,
    private val inscriptionUtilisateur: InscriptionUtilisateur,
    private val jwtService: JwtService,
    private val passwordEncoder: PasswordEncoder
) : UtilisateurControllerDocumentation {

    @PostMapping("/login")
    override fun connexion(@RequestBody connexionUtilisateurRestRessource: ConnexionUtilisateurRestRessource): ResponseEntity<LoginResponse> {
        val utilisateur = connexionUtilisateur(connexionUtilisateurRestRessource.email,connexionUtilisateurRestRessource.motDePasse).toUtilisateurDocument()
        val jwtToken: String = jwtService.generateToken(utilisateur)
        val loginResponse = LoginResponse(token = jwtToken, expiresIn = jwtService.getExpirationTime())
        return ResponseEntity.ok(loginResponse)
    }


    @PostMapping("/register")
    override fun inscription(@RequestBody inscriptionUtilisateurRestRessource: InscriptionUtilisateurRestRessource): ResponseEntity<Utilisateur> {

        inscriptionUtilisateurRestRessource.motDePasse.ifBlank { throw MotDePasseInvalideException("Le mot de passe est invalide") }
        val passwordEncoder = passwordEncoder.encode(inscriptionUtilisateurRestRessource.motDePasse)

        val utilisateurRestRessource = inscriptionUtilisateurRestRessource.toUtilisateur().copy(motDePasse = passwordEncoder)
        val utilisateur = inscriptionUtilisateur(utilisateurRestRessource)
        return ResponseEntity.ok(utilisateur)
    }
}
