package com.bav.airneisbackend.categorie.userside.mapper

import com.bav.airneisbackend.categorie.domain.model.Categorie
import com.bav.airneisbackend.categorie.domain.model.Produit
import com.bav.airneisbackend.categorie.userside.dto.CategorieRestRessource
import com.bav.airneisbackend.categorie.userside.dto.PourCreerCategorieRestRessource

object CategorieMapper {
    fun PourCreerCategorieRestRessource.toCategorie() =Categorie(
        nom = nom,
        image = image,
        produit = produit.map { Produit(it.id,"") }
    )

    fun Categorie.toCategorieRestRessource() = CategorieRestRessource(
        id = id,
        nom = nom,
        image = image,
        produits = produit
    )
}