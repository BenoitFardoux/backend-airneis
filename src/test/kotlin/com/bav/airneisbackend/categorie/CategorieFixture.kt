package com.bav.airneisbackend.categorie

import com.bav.airneisbackend.categorie.domain.model.Categorie
import com.bav.airneisbackend.categorie.domain.model.Image
import com.bav.airneisbackend.categorie.domain.model.Produit
import com.bav.airneisbackend.categorie.serverside.dto.CategorieDocument
import com.bav.airneisbackend.categorie.userside.dto.CategorieRestRessource
import com.bav.airneisbackend.categorie.userside.dto.PourCreerCategorieRestRessource
import com.bav.airneisbackend.utilisateur.domain.model.Panier

class CategorieFixture {
    companion object {
        private  val id = "12333"
        private val nom = "Categorie 1"
        private val image = Image("url de liamge", "description de l'image")
        private val produit = mutableListOf<Produit>()

        val categorieDocument = CategorieDocument(id, nom, image, produit)
        val uneCategorie =
            Categorie(
                id = id,
                nom = nom,
                image = image,
                produits = produit
            )
        val categorieSansNom = Categorie(
            id = id,
            nom = "",
            image = image,
            produits = produit
        )
        val categorieRestRessource = CategorieRestRessource(
            id = id,
            nom = nom,
            image = image,
            produits = emptyList()
        )
        val pourCreerCategorieRestRessource = PourCreerCategorieRestRessource(
            nom = nom,
            image = image,
            produit = emptyList()
        )

    }
}