package com.bav.airneisbackend.categorie.domain.model

data class Produit (
    val id : String,
    val nom : String,
    val description : String,
    val prix : Double,
    val image : Image
)