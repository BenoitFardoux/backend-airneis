package com.bav.airneisbackend.utilisateur.serverside.adapter.repository

import com.bav.airneisbackend.utilisateur.domain.model.Adresse
import com.bav.airneisbackend.utilisateur.domain.model.Utilisateur
import com.bav.airneisbackend.utilisateur.domain.port.serverside.adresse.SupprimerAdresseServerSidePort
import com.bav.airneisbackend.utilisateur.serverside.adapter.mongodb.repository.MongoDbUtilisateurRepository
import com.bav.airneisbackend.utilisateur.serverside.dto.UtilisateurDocument
import com.bav.airneisbackend.utilisateur.serverside.exception.AdresseIntrouvableException
import com.bav.airneisbackend.utilisateur.serverside.mapper.UtilisateurMapper.toUtilisateur
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Repository


@Repository
class SupprimerAdresseRepository (val mongoDbUtilisateurRepository: MongoDbUtilisateurRepository) :
    SupprimerAdresseServerSidePort{

    override fun invoke(adresse: Adresse): Utilisateur {
        val authentication = SecurityContextHolder.getContext().authentication

        val currentUser: UtilisateurDocument = authentication.principal as UtilisateurDocument

        if (!currentUser.adresse.remove(adresse)){
            throw AdresseIntrouvableException()
        }

        return mongoDbUtilisateurRepository.save(currentUser).toUtilisateur()
    }

}