package com.bav.airneisbackend.airneis.serverside.dto

import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.MongoId


@Document("referentielDeMateriau")
data class ReferentielDeMateriauDocument (
    @MongoId
    val id : String,
    val name : String
)