package com.bav.airneisbackend.Produit.domain.model


data class Produit(
    val id: String?,
    val prix: Double,
    val nom: String,
    val description: String,
    val dimension: Dimension,
    val categorie: Categorie,
    val images: List<String>,
    val materiaux: List<Materiau>

) {
    data class Dimension(
        val hauteur: Double,
        val largeur: Double,
        val profondeur: Double
    )
}

