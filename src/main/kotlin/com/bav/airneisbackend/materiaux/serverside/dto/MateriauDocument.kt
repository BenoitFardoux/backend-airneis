package com.bav.airneisbackend.materiaux.serverside.dto

import com.bav.airneisbackend.materiaux.domain.model.Image
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.MongoId


@Document("materiau")
data class MateriauDocument(
    @MongoId
    val id: String = "",
    val nom : String,
    val type : String,
    val image : Image
)   
