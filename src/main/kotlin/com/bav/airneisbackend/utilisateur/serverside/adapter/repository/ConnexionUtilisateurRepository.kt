package com.bav.airneisbackend.utilisateur.serverside.adapter.repository

import com.bav.airneisbackend.utilisateur.domain.model.Utilisateur
import com.bav.airneisbackend.utilisateur.domain.port.serverside.ConnexionUtilisateurServerSidePort
import com.bav.airneisbackend.utilisateur.serverside.adapter.mongodb.repository.MongoDbUtilisateurRepository
import com.bav.airneisbackend.utilisateur.serverside.exception.UtilisateurNonTrouveException
import com.bav.airneisbackend.utilisateur.serverside.mapper.UtilisateurMapper.toUtilisateur
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.stereotype.Repository


@Repository
class ConnexionUtilisateurRepository(private val mongoDbUtilisateurRepository: MongoDbUtilisateurRepository, private val authenticationManager: AuthenticationManager) : ConnexionUtilisateurServerSidePort {
    override fun invoke(email: String, motDePasse : String): Utilisateur {
        authenticationManager.authenticate(UsernamePasswordAuthenticationToken(email, motDePasse))

        return mongoDbUtilisateurRepository.findByEmail(email)?.toUtilisateur() ?: throw UtilisateurNonTrouveException()
    }
}