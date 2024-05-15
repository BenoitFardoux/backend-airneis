package com.bav.airneisbackend.categorie

import com.bav.airneisbackend.categorie.domain.model.Categorie
import com.bav.airneisbackend.categorie.domain.model.Image
import com.bav.airneisbackend.categorie.domain.model.Produit
import com.bav.airneisbackend.categorie.serverside.dto.CategorieDocument

class CategorieFixture {
    companion object {
        private const val id = "1"
        private const val nom = "Categorie 1"
        private val image = Image("url", "description")
        private val produit = emptyList<Produit>()

        val categorieDocument = CategorieDocument(id, nom, image, produit)
        val uneCategorie =
            Categorie(
                id = id,
                nom = nom,
                image = image,
                produit = produit
            )
        val categorieSansNom = Categorie(
            id = id,
            nom = "",
            image = image,
            produit = produit
        )

    }
}