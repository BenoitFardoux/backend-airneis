package com.bav.airneisbackend.produit.userside.restressources

import com.bav.airneisbackend.produit.domain.model.Categorie
import com.bav.airneisbackend.produit.domain.model.Dimension
import com.bav.airneisbackend.produit.domain.model.Materiau

data class ProduitRestRessource(
    val id: String?,
    val prix: Double,
    val nom: String,
    val description: String,
    val dimension : Dimension,
    val categorie : Categorie,
    val images: List<String>,
    val materiaux: List<Materiau>
)
