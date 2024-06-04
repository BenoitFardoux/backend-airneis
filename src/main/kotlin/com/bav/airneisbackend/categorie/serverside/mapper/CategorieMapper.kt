package com.bav.airneisbackend.categorie.serverside.mapper

import com.bav.airneisbackend.categorie.domain.model.Categorie
import com.bav.airneisbackend.categorie.serverside.dto.CategorieDocument
import org.bson.types.ObjectId

object CategorieMapper {
    fun CategorieDocument.toCategorie() : Categorie =
        Categorie(
            id = id,
            nom = nom,
            image = image,
            produits = produits
        )

    fun Categorie.toCategorieDocument() : CategorieDocument=
        CategorieDocument(
            id = id.ifEmpty { ObjectId().toHexString() },
            nom = nom,
            image = image,
            produits = produits
        )
}



