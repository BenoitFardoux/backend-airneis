package com.bav.airneisbackend.categorie.serverside.dto

import com.bav.airneisbackend.categorie.domain.model.Image
import com.bav.airneisbackend.categorie.domain.model.Produit

import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.MongoId


@Document("categorie")
data class CategorieDocument(
    @MongoId
    val id: String = "",
    val nom: String,
    val image : Image,
    val produits: MutableList<Produit>
)