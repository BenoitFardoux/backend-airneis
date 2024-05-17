package com.bav.airneisbackend.categorie

import com.bav.airneisbackend.categorie.domain.model.Categorie
import com.bav.airneisbackend.categorie.domain.model.Image
import com.bav.airneisbackend.categorie.domain.model.Produit
import com.bav.airneisbackend.categorie.serverside.dto.CategorieDocument
import com.bav.airneisbackend.categorie.serverside.dto.ProduitDocument
import com.bav.airneisbackend.categorie.userside.dto.PourCreerCategorieRestRessource

class CategorieFixture {
    companion object {
        private  val id = "1"
        private val nom = "Categorie 1"
        private val image = Image("url de liamge", "description de l'image")
        private val produit = emptyList<Produit>()
        private val produitDocument = emptyList<ProduitDocument>()

        val categorieDocument = CategorieDocument(id, nom, image, produitDocument)
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

        val pourCreerCategorieRestRessource = PourCreerCategorieRestRessource(
            nom = nom,
            image = image,
            produit = emptyList()
        )

    }
}