package com.bav.airneisbackend.utilisateur.serverside.adapter.repository

import com.bav.airneisbackend.utilisateur.domain.model.Utilisateur
import com.bav.airneisbackend.utilisateur.domain.port.serverside.PourRecupererUtilisateurParMailServerSidePort
import com.bav.airneisbackend.utilisateur.serverside.adapter.mongodb.repository.MongoDbUtilisateurRepository
import com.bav.airneisbackend.utilisateur.serverside.exception.UtilisateurNonTrouveException
import com.bav.airneisbackend.utilisateur.serverside.mapper.UtilisateurMapper.toUtilisateur
import org.springframework.stereotype.Repository


@Repository
class PourRecupererUtilisateurParMailRepository(private val mongoDbUtilisateurRepository: MongoDbUtilisateurRepository) : PourRecupererUtilisateurParMailServerSidePort {
    override fun invoke(email: String): Utilisateur {
        return mongoDbUtilisateurRepository.findByEmail(email)?.toUtilisateur() ?: throw UtilisateurNonTrouveException()
    }
}