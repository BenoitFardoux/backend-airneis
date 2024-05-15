package com.bav.airneisbackend.produit.userside.mapper

import com.bav.airneisbackend.produit.domain.model.Materiau
import com.bav.airneisbackend.produit.domain.model.Produit
import com.bav.airneisbackend.produit.userside.restressources.CreerProduitRestRessource
import com.bav.airneisbackend.produit.userside.restressources.ProduitRestRessource
import com.bav.airneisbackend.produit.userside.restressources.materiau.MateriauPourCreerProduitRestRessource
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

    fun materiauProduitRestRessourceToMateriau(materiauPourCreerProduitRestRessource: MateriauPourCreerProduitRestRessource): Materiau =
        with(materiauPourCreerProduitRestRessource) {
            return Materiau(
                id
            )
        }

    fun creerProduitRestRessourceToProduit(creerProduitRestRessource: CreerProduitRestRessource): Produit {

        with(creerProduitRestRessource) {

            return Produit(
                nom = nom,
                description = description,
                prix = prix,
                images = images,
                dimension = dimension,
                categorie = categorie,
                materiaux = materiaux.map { materiauProduitRestRessourceToMateriau(it) }
            )
        }
    }
}