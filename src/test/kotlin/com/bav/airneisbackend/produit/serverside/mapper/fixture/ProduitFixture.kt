package com.bav.airneisbackend.produit.serverside.mapper.fixture

import com.bav.airneisbackend.produit.domain.model.Materiau
import com.bav.airneisbackend.produit.domain.model.Categorie
import com.bav.airneisbackend.produit.domain.model.Dimension
import com.bav.airneisbackend.produit.domain.model.Produit
import com.bav.airneisbackend.produit.serverside.dto.ProduitDocument
import org.bson.types.ObjectId

class ProduitFixture {
    companion object {
        val dimension = Dimension(
            hauteur = 10.0,
            largeur = 10.0,
            profondeur = 10.0
        )
        val categorie = Categorie(
            id = ObjectId.get(),
            nom = "chaise"
        )

        val materiau = Materiau(
            id = ObjectId.get(),
            nom = "bois"
        )

        val materiaux = listOf(materiau)

        val produitDocument = ProduitDocument(
            id = ObjectId.get(),
            nom = "Chaise",
            description = "une chaise en bois",
            prix = 10.0,
            categorie = categorie,
            materiaux = materiaux,
            images = listOf("lien chaise"),
            dimension = dimension
        )

        val produit = Produit(
            id = ObjectId.get(),
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