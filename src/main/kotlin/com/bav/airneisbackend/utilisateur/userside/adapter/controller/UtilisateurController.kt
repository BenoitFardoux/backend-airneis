package com.bav.airneisbackend.utilisateur.userside.adapter.controller

import com.bav.airneisbackend.utilisateur.serverside.dto.UtilisateurDocument
import com.bav.airneisbackend.utilisateur.serverside.mapper.UtilisateurMapper.toUtilisateur
import com.bav.airneisbackend.utilisateur.userside.adapter.controller.documentation.UtilisateurControllerDocumentation
import com.bav.airneisbackend.utilisateur.userside.mapper.UtilisateurMapper.toUtilisateurRestRessource
import com.bav.airneisbackend.utilisateur.userside.restressource.UtilisateurRestRessource
import org.springframework.http.ResponseEntity
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/utilisateur")
class UtilisateurController : UtilisateurControllerDocumentation {

    @GetMapping("/me")
    override fun utilisateurActuel(): ResponseEntity<UtilisateurRestRessource> {
        val authentication = SecurityContextHolder.getContext().authentication

        val currentUser = authentication.principal as UtilisateurDocument
        return ResponseEntity.ok().body(currentUser.toUtilisateur().toUtilisateurRestRessource())

    }

}