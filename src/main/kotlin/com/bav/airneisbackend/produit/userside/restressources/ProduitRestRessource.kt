package com.bav.airneisbackend.produit.userside.restressources

import com.bav.airneisbackend.produit.domain.model.Categorie
import com.bav.airneisbackend.produit.domain.model.Image
import com.bav.airneisbackend.produit.domain.model.Materiau
import com.bav.airneisbackend.produit.domain.model.Produit

data class ProduitRestRessource(
    val id: String?,
    val prix: Double,
    val nom: String,
    val description: String,
    val dimension : Produit.Dimension,
    val categorie : Categorie,
    val images: List<Image>,
    val materiaux: List<Materiau>
)
