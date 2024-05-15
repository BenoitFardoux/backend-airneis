package com.bav.airneisbackend.Materiaux.serverside.dto

import com.bav.airneisbackend.Materiaux.domain.model.Image
import com.bav.airneisbackend.Materiaux.domain.model.Materiau
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
