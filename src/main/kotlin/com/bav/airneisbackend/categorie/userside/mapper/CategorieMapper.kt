package com.bav.airneisbackend.categorie.userside.mapper

import com.bav.airneisbackend.categorie.domain.model.Categorie
import com.bav.airneisbackend.categorie.domain.model.Produit
import com.bav.airneisbackend.categorie.userside.dto.CategorieRestRessource
import com.bav.airneisbackend.categorie.userside.dto.PourCreerCategorieRestRessource
import com.bav.airneisbackend.categorie.userside.dto.ProduitPourCategorieRestRessource

object CategorieMapper {
    fun PourCreerCategorieRestRessource.toCategorie() =Categorie(
        nom = nom,
        image = image,
        produits = produit.map { Produit(id = it.id)  }.toMutableList()
    )

    fun Categorie.toCategorieRestRessource(produits: List<ProduitPourCategorieRestRessource>) = CategorieRestRessource(
        id = id,
        nom = nom,
        image = image,
        produits = produits
    )
}