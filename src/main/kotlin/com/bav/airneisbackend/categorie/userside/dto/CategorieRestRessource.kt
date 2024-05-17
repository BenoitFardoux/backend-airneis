package com.bav.airneisbackend.categorie.userside.dto

import com.bav.airneisbackend.categorie.domain.model.Image
import com.bav.airneisbackend.categorie.domain.model.Produit
data class CategorieRestRessource(
    val id : String,
    val nom : String,
    val image : Image,
    val produits : List<Produit>
)
