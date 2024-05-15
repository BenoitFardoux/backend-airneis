package com.bav.airneisbackend.produit.fixture

import com.bav.airneisbackend.produit.domain.model.Categorie
import com.bav.airneisbackend.produit.domain.model.Image
import com.bav.airneisbackend.produit.domain.model.Produit
import com.bav.airneisbackend.produit.serverside.dto.ProduitDocument
import com.bav.airneisbackend.produit.userside.restressources.CreerProduitRestRessource


class ProduitFixture {
    companion object{
        val dimension = Produit.Dimension(
            100.0, 100.0, 100.0
        )
        val images = listOf(Image(
            url = "table.jpg",
            description = "table"
        ))

        val categorie = Categorie(
            id = "12333",
            nom = "meuble",
        )
        val produitDocument = ProduitDocument(
            id = "123456",
            nom = "table",
            description = "table en chene",
            prix = 100.0,
            images = images,
            dimension = dimension,
            categorie = categorie,
            materiaux = listOf(MateriauFixture.materiau)
        )
        val produit = Produit(
            id = "123456",
            nom = "table",
            description = "table en chene",
            prix = 100.0,
            images = images,
            dimension = dimension,
            categorie = categorie,
            materiaux = listOf(MateriauFixture.materiau)
        )

        val produitSansId = Produit(
            id = "",
            nom = "table",
            description = "table en chene",
            prix = 100.0,
            images = images,
            dimension = dimension,
            categorie = categorie,
            materiaux = listOf(MateriauFixture.materiau)
        )

        val produitPourRequetePost : CreerProduitRestRessource = CreerProduitRestRessource(
            nom = "table",
            description = "table en chene",
            prix = 100.0,
            images = images,
            dimension = dimension,
            categorie = categorie,
            materiaux = listOf(MateriauFixture.materiauPourCreerProduitRestRessource)
        )
    }
}