package com.bav.airneisbackend.produit.serverside.mapper

import com.bav.airneisbackend.produit.domain.model.Produit
import com.bav.airneisbackend.produit.serverside.dto.ProduitDocument
import org.bson.types.ObjectId

object ProduitMapper {
    fun ProduitDocument.toProduit() = Produit(
        id = id,
        nom = nom,
        description = description,
        prix = prix,
        categorie = categorie,
        materiaux = materiaux,
        images = images,
        dimension = dimension
    )
    fun Produit.toProduitDocument() = ProduitDocument(
        id = id.ifEmpty{ ObjectId().toHexString() },
        nom = nom,
        description = description,
        prix = prix,
        categorie = categorie,
        materiaux = materiaux,
        images = images,
        dimension = dimension
    )
}