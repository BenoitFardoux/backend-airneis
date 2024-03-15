package com.bav.airneisbackend.produit.domain.model

import org.bson.types.ObjectId

data class Produit (
    val id: ObjectId,
    val prix: Double,
    val nom: String,
    val description: String,
    val dimension : Dimension,
    val categorie : Categorie,
    val images: List<String>,
    val materiaux: List<Materiau>
)

data class Dimension(
    val hauteur: Double,
    val largeur: Double,
    val profondeur: Double
)