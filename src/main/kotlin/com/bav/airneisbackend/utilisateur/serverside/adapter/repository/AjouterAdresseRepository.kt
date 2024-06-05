package com.bav.airneisbackend.utilisateur.serverside.adapter.repository

import com.bav.airneisbackend.utilisateur.domain.model.Adresse
import com.bav.airneisbackend.utilisateur.domain.model.Utilisateur
import com.bav.airneisbackend.utilisateur.domain.port.serverside.adresse.PourAjouterUneAdresseServerSidePort
import com.bav.airneisbackend.utilisateur.serverside.adapter.mongodb.repository.MongoDbUtilisateurRepository
import com.bav.airneisbackend.utilisateur.serverside.dto.UtilisateurDocument
import com.bav.airneisbackend.utilisateur.serverside.mapper.UtilisateurMapper.toUtilisateur
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Repository


@Repository
class AjouterAdresseRepository(val mongoDbUtilisateurRepository: MongoDbUtilisateurRepository) : PourAjouterUneAdresseServerSidePort {
    override fun invoke(adresse: Adresse) : Utilisateur{
        adresse.estValide()
        val authentication = SecurityContextHolder.getContext().authentication

        val currentUser: UtilisateurDocument = authentication.principal as UtilisateurDocument
        currentUser.adresse.addLast(adresse)
        return mongoDbUtilisateurRepository.save(currentUser).toUtilisateur()

    }
}