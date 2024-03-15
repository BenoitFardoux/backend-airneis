package com.bav.airneisbackend.produit.domain.model

import org.bson.types.ObjectId

data class Materiau(
    val id : ObjectId,
    val nom : String
)
