package com.bav.airneisbackend.categorie.domain.model

data class Categorie (
    val id: String = "" ,
    val nom: String,
    val image : Image,
    val produit: List<Produit> = emptyList()
)