package com.bav.airneisbackend.utilisateur.userside.adapter.controller.documentation

import com.bav.airneisbackend.utilisateur.userside.dto.AuthenticationRequest
import com.bav.airneisbackend.utilisateur.userside.dto.AuthentificationResponse
import com.bav.airneisbackend.utilisateur.userside.dto.RequeteInscription
import org.springframework.http.ResponseEntity

interface UtilisateurControllerDocumentation {
    fun inscrire(requeteInscription: RequeteInscription) : ResponseEntity<String>
    fun authentifier(authenticationRequest: AuthenticationRequest) : ResponseEntity<AuthentificationResponse>
}