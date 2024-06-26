package com.bav.airneisbackend.utilisateur.userside.restressource

import com.bav.airneisbackend.utilisateur.domain.model.Adresse
import com.bav.airneisbackend.utilisateur.domain.model.MoyenDePaiement
import com.bav.airneisbackend.utilisateur.domain.model.produits.Produit
import java.util.Date

data class PanierRestRessource(
    val produits: MutableList<Produit>? = null,
    val adresse: Adresse? = null,
    val paiements: MoyenDePaiement? = null,
    val dateDeCommande: Date? = null,
    val dateDeLivraison: Date? = null
)
