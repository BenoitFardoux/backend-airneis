package com.bav.airneisbackend.Produit.fixture

import com.bav.airneisbackend.Produit.domain.model.Categorie
import com.bav.airneisbackend.Produit.domain.model.Produit
import com.bav.airneisbackend.Produit.serverside.dto.ProduitDocument
import com.bav.airneisbackend.produit.fixture.MateriauFixture


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