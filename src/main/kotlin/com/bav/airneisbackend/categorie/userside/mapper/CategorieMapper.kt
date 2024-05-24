package com.bav.airneisbackend.categorie.userside.mapper

import com.bav.airneisbackend.categorie.domain.model.Categorie
import com.bav.airneisbackend.categorie.domain.model.Produit
import com.bav.airneisbackend.categorie.userside.dto.CategorieRestRessource
import com.bav.airneisbackend.categorie.userside.dto.PourCreerCategorieRestRessource
import org.springframework.data.domain.Page
import org.springframework.hateoas.CollectionModel

object CategorieMapper {
    fun PourCreerCategorieRestRessource.toCategorie() =Categorie(
        nom = nom,
        image = image,
        produit = produit.map { Produit(it.id,"") }
    )

    fun Categorie.toCategorieRestRessource() = CategorieRestRessource(
        id = id,
        nom = nom,
        image = image,
        produits = produit
    )

    fun Page<Categorie>.toCollectionModel() = CollectionModel.of(
        content.map { it.toCategorieRestRessource() }
    )
}