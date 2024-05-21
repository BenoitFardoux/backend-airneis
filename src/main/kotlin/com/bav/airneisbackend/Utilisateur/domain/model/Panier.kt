package com.bav.airneisbackend.Utilisateur.domain.model

import com.bav.airneisbackend.Utilisateur.domain.model.produits.Produit

data class Panier (
    val produits: List<Produit>,
    val id  : String,
    val adresse : Adresse? = null,
    val paiements : Paiments? = null
)