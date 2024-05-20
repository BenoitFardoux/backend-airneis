package com.bav.airneisbackend.utilisateur.domain.model

import com.bav.airneisbackend.utilisateur.domain.model.produits.Produit

data class Panier (
    val produits: List<Produit>,
    val id  : String?
)