package com.bav.airneisbackend.Produit.serverside.dto

import org.bson.types.ObjectId
import org.springframework.data.mongodb.core.mapping.Document

@Document("categorieProduit")
data class CategorieDocument (
    val id : ObjectId,
    val nom : String
)