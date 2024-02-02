package com.bav.airneisbackend.Materiaux.serverside.dto

import org.bson.types.ObjectId
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.MongoId


@Document("materiau")
data class MateriauDocument(
    @MongoId
    val id: ObjectId = ObjectId.get(),
    val materiauId : String,
    val name : String
)   
