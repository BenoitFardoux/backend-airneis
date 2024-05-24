package com.bav.airneisbackend.utilisateur.serverside.adapter.repository

import com.bav.airneisbackend.utilisateur.domain.model.Utilisateur
import com.bav.airneisbackend.utilisateur.domain.port.serverside.InscriptionUtilisateurServerSidePort
import com.bav.airneisbackend.utilisateur.serverside.adapter.mongodb.repository.MongoDbUtilisateurRepository
import com.bav.airneisbackend.utilisateur.serverside.mapper.UtilisateurMapper.toUtilisateur
import com.bav.airneisbackend.utilisateur.serverside.mapper.UtilisateurMapper.toUtilisateurDocument
import com.bav.airneisbackend.utilisateur.serverside.exception.UtilisateurDejaExistantException
import org.springframework.stereotype.Repository


@Repository
class InscriptionUtilisateurRepository(
    val mongoDbUtilisateurRepository: MongoDbUtilisateurRepository
) : InscriptionUtilisateurServerSidePort {
    override fun invoke(utilisateur: Utilisateur) : Utilisateur {
        mongoDbUtilisateurRepository.findByEmail(utilisateur.email)?.let {
            throw UtilisateurDejaExistantException()
        }

        return mongoDbUtilisateurRepository.save(utilisateur.toUtilisateurDocument()).toUtilisateur()
    }

}