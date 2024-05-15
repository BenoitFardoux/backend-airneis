package com.bav.airneisbackend.categorie.serverside.dto

import com.bav.airneisbackend.categorie.domain.model.Image
import com.bav.airneisbackend.categorie.domain.model.Produit
import org.bson.types.ObjectId
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.MongoId


@Document("categorie")
data class CategorieDocument(
    @MongoId
    val id: String =  ObjectId().toHexString() ,
    val nom: String,
    val image : Image,
    val produit: List<Produit>
)