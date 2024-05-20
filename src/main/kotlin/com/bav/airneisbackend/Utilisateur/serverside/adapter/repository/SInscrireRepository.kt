package com.bav.airneisbackend.utilisateur.serverside.adapter.repository

import com.bav.airneisbackend.utilisateur.domain.model.Utilisateur
import com.bav.airneisbackend.utilisateur.domain.port.serverside.PourSIncrireServerSidePort
import com.bav.airneisbackend.utilisateur.serverside.adapter.mongodb.repository.MongoDbUtilisateurRepository
import com.bav.airneisbackend.utilisateur.serverside.mapper.UtilisateurMapper.toUtilisateur
import com.bav.airneisbackend.utilisateur.serverside.mapper.UtilisateurMapper.toUtilisateurDocument
import org.springframework.stereotype.Repository


@Repository
class SInscrireRepository(private val mongoDbUtilisateurRepository: MongoDbUtilisateurRepository) :
    PourSIncrireServerSidePort {
    override fun invoke(utilisateur: Utilisateur) : Utilisateur{
        val existingUser = mongoDbUtilisateurRepository.findByEmail(utilisateur.email)
        if (existingUser != null) {
            throw IllegalArgumentException("Nom d'utilisateur déjà utilisé")
        }


        return mongoDbUtilisateurRepository.save(utilisateur.toUtilisateurDocument()).toUtilisateur()

    }
}