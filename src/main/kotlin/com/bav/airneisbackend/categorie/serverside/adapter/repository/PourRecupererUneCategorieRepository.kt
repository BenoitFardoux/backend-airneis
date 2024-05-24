package com.bav.airneisbackend.categorie.serverside.adapter.repository

import com.bav.airneisbackend.categorie.domain.exception.CategorieInconnueException
import com.bav.airneisbackend.categorie.domain.model.Categorie
import com.bav.airneisbackend.categorie.domain.model.Produit
import com.bav.airneisbackend.categorie.domain.port.serverside.categorie.PourRecupererUneCategorie
import com.bav.airneisbackend.categorie.serverside.adapter.mongodb.repository.MongoDbCategorieRepository
import com.bav.airneisbackend.categorie.serverside.mapper.CategorieMapper.toCategorie
import com.bav.airneisbackend.produit.serverside.adapter.mongodb.repository.MongoDbProduitRepository
import org.springframework.stereotype.Repository


@Repository
class PourRecupererUneCategorieRepository(
    private val categorieRepository: MongoDbCategorieRepository,
    private val produitRepository: MongoDbProduitRepository
) : PourRecupererUneCategorie {
  override fun invoke(id: String): Categorie {
    val categorieRecupere = categorieRepository.findById(id)
        .orElseThrow { CategorieInconnueException(id) }

    return categorieRecupere.toCategorie(
        categorieRecupere.produit.map {
          produitDocument -> Produit(
            produitDocument.id,
            produitRepository.findById(produitDocument.id).get().nom
          )
        }
    )
  }
}