package com.bav.airneisbackend.utilisateur.userside.restressource

import com.bav.airneisbackend.utilisateur.domain.model.produits.Produit

data class SuppressionArticleDansPanierRestRessource (

    val message : String,
    val articleSupprime : Produit
)
