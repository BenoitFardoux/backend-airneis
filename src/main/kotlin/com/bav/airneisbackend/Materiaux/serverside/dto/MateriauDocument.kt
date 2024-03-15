package com.bav.airneisbackend.Materiaux.serverside.dto

import org.bson.types.ObjectId
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.MongoId


@Document("materiau")
data class MateriauDocument(
    @MongoId
    val id: ObjectId,
    val nom : String,
    val type : String,
    val image : String
)   
