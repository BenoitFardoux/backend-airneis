package com.bav.airneisbackend.produit.domain.model


data class Produit (
    val id: String?,
    val prix: Double,
    val nom: String,
    val description: String,
    val dimension : Dimension,
    val categorie : Categorie,
    val images: List<String>,
    val materiaux: List<Materiau>
)

