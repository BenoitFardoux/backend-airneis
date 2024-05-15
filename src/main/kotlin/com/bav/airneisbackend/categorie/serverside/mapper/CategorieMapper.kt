package com.bav.airneisbackend.categorie.serverside.mapper

import com.bav.airneisbackend.categorie.domain.model.Categorie
import com.bav.airneisbackend.categorie.serverside.dto.CategorieDocument

object CategorieMapper {
    fun CategorieDocument.toCategorie() : Categorie =
        Categorie(
            id = id,
            nom = nom,
            image = image,
            produit = produit
        )

    fun Categorie.toCategorieDocument() : CategorieDocument=
        CategorieDocument(
            id = id,
            nom = nom,
            image = image,
            produit = produit
        )
}