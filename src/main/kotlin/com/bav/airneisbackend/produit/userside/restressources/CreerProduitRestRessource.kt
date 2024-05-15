package com.bav.airneisbackend.produit.userside.restressources

import com.bav.airneisbackend.produit.domain.model.Categorie
import com.bav.airneisbackend.produit.domain.model.Image
import com.bav.airneisbackend.produit.domain.model.Produit
import com.bav.airneisbackend.produit.userside.restressources.materiau.MateriauPourCreerProduitRestRessource

data class CreerProduitRestRessource(
    val prix: Double,
    val nom: String,
    val description: String,
    val dimension: Produit.Dimension,
    val categorie: Categorie,
    val images: List<Image>,
    val materiaux: List<MateriauPourCreerProduitRestRessource>
)
