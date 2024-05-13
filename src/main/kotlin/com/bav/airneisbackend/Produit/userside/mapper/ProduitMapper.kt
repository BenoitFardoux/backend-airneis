package com.bav.airneisbackend.Produit.userside.mapper

import com.bav.airneisbackend.Produit.domain.model.Produit
import com.bav.airneisbackend.Produit.userside.restressources.ProduitRestRessource
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl

object ProduitMapper {
    private fun produitToProduitRestRessource(produits: List<Produit>): List<ProduitRestRessource> {
        return produits.map { produit: Produit ->
            with(produit) {
                ProduitRestRessource(
                    id = id,
                    prix = prix,
                    nom = nom,
                    description = description,
                    dimension = dimension,
                    categorie = categorie,
                    images = images,
                    materiaux = materiaux
                )
            }
        }
    }

    fun mapProduitPageToProduitRestRessource(pageProduit: Page<Produit>): Page<ProduitRestRessource> {
        val mappedProduct = produitToProduitRestRessource(pageProduit.content)
        return PageImpl(mappedProduct, pageProduit.pageable, pageProduit.totalElements)
    }

    fun mapProduitToProduitRestRessource(produit: Produit): ProduitRestRessource {
        with(produit) {
            return ProduitRestRessource(
                id = id,
                prix = prix,
                nom = nom,
                description = description,
                dimension = dimension,
                categorie = categorie,
                images = images,
                materiaux = materiaux
            )
        }
    }
}