package com.bav.airneisbackend.categorie.userside.dto

import com.bav.airneisbackend.categorie.domain.model.Image
import com.bav.airneisbackend.categorie.domain.model.Produit

data class PourCreerCategorieRestRessource(
    val nom : String,
    val image : Image,
    val produit: List<Produit>
    = emptyList()
)