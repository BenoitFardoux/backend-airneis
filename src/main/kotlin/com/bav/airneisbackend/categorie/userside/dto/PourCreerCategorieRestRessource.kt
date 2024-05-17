package com.bav.airneisbackend.categorie.userside.dto

import com.bav.airneisbackend.categorie.domain.model.Image

data class PourCreerCategorieRestRessource(
    val nom : String,
    val image : Image,
    val produit: List<PourCreerCategorieProduitRestRessource>
){
    data class PourCreerCategorieProduitRestRessource(
        val id : String,
    )
}