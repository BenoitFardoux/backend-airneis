package com.bav.airneisbackend.categorie.serverside.mapper

import com.bav.airneisbackend.categorie.domain.model.Categorie
import com.bav.airneisbackend.categorie.domain.model.Produit
import com.bav.airneisbackend.categorie.serverside.dto.CategorieDocument
import com.bav.airneisbackend.categorie.serverside.dto.ProduitDocument
import org.bson.types.ObjectId

object CategorieMapper {
    fun CategorieDocument.toCategorie(produits : List<Produit>) : Categorie =
        Categorie(
            id = id,
            nom = nom,
            image = image,
            produit = produits
        )

    fun Categorie.toCategorieDocument() : CategorieDocument=
        CategorieDocument(
            id = id.ifEmpty { ObjectId().toHexString() },
            nom = nom,
            image = image,
            produit = produit.map { it.toProduitDocument() }
        )
}



fun Produit.toProduitDocument() : ProduitDocument = ProduitDocument(id)