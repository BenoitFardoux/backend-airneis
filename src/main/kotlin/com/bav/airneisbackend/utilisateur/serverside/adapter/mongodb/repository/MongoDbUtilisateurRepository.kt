package com.bav.airneisbackend.utilisateur.serverside.adapter.mongodb.repository

import com.bav.airneisbackend.utilisateur.serverside.dto.UtilisateurDocument
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository


@Repository
interface MongoDbUtilisateurRepository : MongoRepository<UtilisateurDocument, String> {
    fun findByEmail(email: String): UtilisateurDocument?
}