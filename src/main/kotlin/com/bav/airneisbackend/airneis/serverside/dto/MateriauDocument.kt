package com.bav.airneisbackend.airneis.serverside.dto

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.MongoId


@Document("materiau")
data class MateriauDocument(
    @MongoId
    val id: ObjectId = ObjectId.get(),
    val materiauId : String,
    val name : String
)   
