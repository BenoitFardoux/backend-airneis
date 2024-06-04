package com.bav.airneisbackend.categorie.userside.dto

import com.bav.airneisbackend.categorie.domain.model.Image

data class ProduitPourCategorieRestRessource(
    val id : String,
    val nom : String,
    val description : String,
    val prix : Double,
    val image : Image
)
