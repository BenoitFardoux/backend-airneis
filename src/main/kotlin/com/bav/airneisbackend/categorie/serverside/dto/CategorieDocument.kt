package com.bav.airneisbackend.categorie.serverside.dto

import org.springframework.data.mongodb.core.mapping.Document


@Document("categorie")
data class CategorieDocument(
    val id: String,
    val nom: String,
    val description: String
)