package com.bav.airneisbackend.utilisateur.serverside.adapter.mongodb.repository

import com.bav.airneisbackend.utilisateur.serverside.dto.UserDocument
import org.springframework.data.mongodb.repository.MongoRepository

interface MongoDbUtilisateruRepository : MongoRepository<UserDocument, String>{
    fun findByUsername(username: String) : UserDocument
}