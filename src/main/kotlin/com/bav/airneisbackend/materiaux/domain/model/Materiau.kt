package com.bav.airneisbackend.materiaux.domain.model


data class Materiau(
    val id : String = "",
    val nom : String,
    val type :String,
    val image : Image
)