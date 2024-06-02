package com.bav.airneisbackend.utilisateur.domain.model

import com.bav.airneisbackend.utilisateur.domain.model.produits.Produit
import java.util.Date

data class Panier(
    val produits: MutableList<Produit>,
    val id: String,
    val adresse: Adresse? = null,
    val paiements: MoyenDePaiement? = null,
    val dateDeCommande: Date? = null,
    val dateDeLivraison: Date? = null
)