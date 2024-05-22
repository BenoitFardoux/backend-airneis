package com.bav.airneisbackend.categorie.serverside.adapter.repository

import com.bav.airneisbackend.categorie.domain.model.Categorie
import com.bav.airneisbackend.categorie.domain.model.Produit
import com.bav.airneisbackend.categorie.domain.port.serverside.categorie.PourRecupererCategories
import com.bav.airneisbackend.categorie.serverside.adapter.mongodb.repository.MongoDbCategorieRepository
import com.bav.airneisbackend.categorie.serverside.mapper.CategorieMapper.toCategorie
import com.bav.airneisbackend.produit.serverside.adapter.mongodb.repository.MongoDbProduitRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Repository


@Repository
class PourRecupererCategorieRepository(
    val categorieRepository: MongoDbCategorieRepository,
    val produitRepository: MongoDbProduitRepository
)
  : PourRecupererCategories{
  override fun invoke(pageable: Pageable): Page<Categorie> {
    val categoriesRecupere = categorieRepository.findAll(pageable)
    return categoriesRecupere.map {
      it.toCategorie(it.produit.map {
        produitDocument -> Produit(
          produitDocument.id,
          produitRepository.findById(produitDocument.id).get().nom
        )
      })
    }
  }

}