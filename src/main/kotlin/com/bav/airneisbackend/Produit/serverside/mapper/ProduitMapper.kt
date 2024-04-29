package com.bav.airneisbackend.Produit.serverside.mapper

import com.bav.airneisbackend.Produit.domain.model.Produit
import com.bav.airneisbackend.Produit.serverside.dto.ProduitDocument

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
}