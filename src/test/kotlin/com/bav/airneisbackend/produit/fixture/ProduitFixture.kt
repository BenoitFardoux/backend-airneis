package com.bav.airneisbackend.produit.fixture

import com.bav.airneisbackend.produit.domain.model.Categorie
import com.bav.airneisbackend.produit.domain.model.Produit
import com.bav.airneisbackend.produit.serverside.dto.ProduitDocument


class ProduitFixture {
    companion object{
        val dimension = Produit.Dimension(
            100.0, 100.0, 100.0
        )

        val categorie = Categorie(
            id = "12333",
            nom = "meuble",
        )
        val produitDocument = ProduitDocument(
            id = "123456",
            nom = "table",
            description = "table en chene",
            prix = 100.0,
            images = listOf("table.jpg"),
            dimension = dimension,
            categorie = categorie,
            materiaux = listOf(MateriauFixture.materiau)
        )
        val produit = Produit(
            id = "123456",
            nom = "table",
            description = "table en chene",
            prix = 100.0,
            images = listOf("table.jpg"),
            dimension = dimension,
            categorie = categorie,
            materiaux = listOf(MateriauFixture.materiau)
        )
    }
}