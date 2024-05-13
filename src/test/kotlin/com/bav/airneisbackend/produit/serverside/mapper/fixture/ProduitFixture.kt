package com.bav.airneisbackend.produit.serverside.mapper.fixture

import com.bav.airneisbackend.produit.domain.model.Materiau
import com.bav.airneisbackend.produit.domain.model.Categorie
import com.bav.airneisbackend.produit.domain.model.Produit
import com.bav.airneisbackend.produit.serverside.dto.ProduitDocument

class ProduitFixture {
    companion object {
        val dimension = Produit.Dimension(
            hauteur = 10.0,
            largeur = 10.0,
            profondeur = 10.0
        )
        val categorie = Categorie(
            id = "",
            nom = "chaise"
        )

        val materiau = Materiau(
            id = "",
            nom = "bois"
        )

        val materiaux = listOf(materiau)

        val produitDocument = ProduitDocument(
            id = "",
            nom = "Chaise",
            description = "une chaise en bois",
            prix = 10.0,
            categorie = categorie,
            materiaux = materiaux,
            images = listOf("lien chaise"),
            dimension = dimension
        )

        val produit = Produit(
            id = "",
            nom = "Chaise",
            description = "une chaise en bois",
            prix = 10.0,
            categorie = categorie,
            materiaux = materiaux,
            images = listOf("lien chaise"),
            dimension = dimension
        )
    }
}