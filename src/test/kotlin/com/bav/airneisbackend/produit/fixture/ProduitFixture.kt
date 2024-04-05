package com.bav.airneisbackend.produit.fixture

import com.bav.airneisbackend.produit.domain.model.Categorie
import com.bav.airneisbackend.produit.domain.model.Dimension
import com.bav.airneisbackend.produit.domain.model.Produit
import com.bav.airneisbackend.produit.serverside.dto.ProduitDocument

class ProduitFixture {
    companion object{
        val dimension = Dimension(
            100.0,100.0,100.0
        )

        val categorie = Categorie(
            id = "",
            nom = "meuble",
        )
        val produitDocument = ProduitDocument(
            id = "",
            nom = "table",
            description = "table en chene",
            prix = 100.0,
            images = listOf("table.jpg"),
            dimension = dimension,
            categorie = categorie,
            materiaux = listOf(MateriauFixture.materiau)
        )
        val produit = Produit(
            id = "",
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