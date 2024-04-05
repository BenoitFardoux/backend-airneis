package com.bav.airneisbackend.produit.domain.model

import org.bson.types.ObjectId

data class Categorie (
    val id : ObjectId,
    val nom : String
)