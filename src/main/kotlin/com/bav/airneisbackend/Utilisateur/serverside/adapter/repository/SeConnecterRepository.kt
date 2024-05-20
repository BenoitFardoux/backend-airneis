package com.bav.airneisbackend.utilisateur.serverside.adapter.repository

import com.bav.airneisbackend.utilisateur.domain.model.Utilisateur
import com.bav.airneisbackend.utilisateur.domain.port.serverside.PourSeConnecterServerSidePort
import com.bav.airneisbackend.utilisateur.serverside.adapter.mongodb.repository.MongoDbUtilisateurRepository
import com.bav.airneisbackend.utilisateur.serverside.dto.UtilisateurDocument
import com.bav.airneisbackend.utils.JwtUtil
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.stereotype.Repository


@Repository
class SeConnecterRepository(
    private val authenticationManager: AuthenticationManager,
    private val mongoDbUtilisateurRepository: MongoDbUtilisateurRepository,
    private val jwtUtil: JwtUtil
) : PourSeConnecterServerSidePort {
    override fun invoke(utilisateur: Utilisateur): String {
        authenticationManager.authenticate(
            UsernamePasswordAuthenticationToken(utilisateur.email, utilisateur.password)
        )
        val userDetails: UtilisateurDocument = mongoDbUtilisateurRepository.findByEmail(utilisateur.email)
            ?: throw IllegalArgumentException("Utilisateur non trouvé")

        return jwtUtil.generateToken(userDetails.username)
    }
}