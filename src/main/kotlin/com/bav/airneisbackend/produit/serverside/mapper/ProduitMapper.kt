package com.bav.airneisbackend.produit.serverside.mapper

import com.bav.airneisbackend.produit.domain.model.Produit
import com.bav.airneisbackend.produit.serverside.dto.ProduitDocument

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