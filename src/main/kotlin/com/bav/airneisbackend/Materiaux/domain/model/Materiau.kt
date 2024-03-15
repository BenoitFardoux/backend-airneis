package com.bav.airneisbackend.Materiaux.domain.model

import org.bson.types.ObjectId

data class Materiau(
    val id : ObjectId,
    val nom : String,
    val type :String,
    val image : String
)
