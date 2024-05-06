package com.bav.airneisbackend.Produit.userside.restressources

import com.bav.airneisbackend.Produit.domain.model.Categorie
import com.bav.airneisbackend.Produit.domain.model.Materiau
import com.bav.airneisbackend.Produit.domain.model.Produit

data class ProduitRestRessource(
    val id: String?,
    val prix: Double,
    val nom: String,
    val description: String,
    val dimension : Produit.Dimension,
    val categorie : Categorie,
    val images: List<String>,
    val materiaux: List<Materiau>
)
