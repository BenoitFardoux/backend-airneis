package com.bav.airneisbackend.categorie.userside.dto

import com.bav.airneisbackend.categorie.domain.model.Image

data class CategorieRestRessource(
    val id : String,
    val nom : String,
    val image : Image,
    val produits : List<ProduitPourCategorieRestRessource>
)
