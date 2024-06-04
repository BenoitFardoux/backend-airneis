package com.bav.airneisbackend.categorie.serverside.adapter.repository

import com.bav.airneisbackend.categorie.domain.exception.CategorieNonTrouveeException
import com.bav.airneisbackend.categorie.domain.model.Categorie
import com.bav.airneisbackend.categorie.domain.port.serverside.categorie.PourRecupererUneCategorie
import com.bav.airneisbackend.categorie.serverside.adapter.mongodb.repository.MongoDbCategorieRepository
import com.bav.airneisbackend.categorie.serverside.mapper.CategorieMapper.toCategorie
import com.bav.airneisbackend.produit.serverside.adapter.mongodb.repository.MongoDbProduitRepository
import org.springframework.stereotype.Repository


@Repository
class PourRecupererUneCategorieRepository(
    val mongoDbCategorieRepository: MongoDbCategorieRepository,
    val mongoDbProduitRepository: MongoDbProduitRepository
) :
    PourRecupererUneCategorie {
    override fun invoke(id: String): Categorie {
        if (!mongoDbCategorieRepository.existsById(id)) {
            throw CategorieNonTrouveeException(id)
        }
        val categorie = mongoDbCategorieRepository.findById(id).get()
        var bool = false
        categorie.produits.map { item ->
            mongoDbProduitRepository.existsById(item.id).let {
                if (!it){
                    categorie.produits.remove(item)
                    bool = true
                }
            }
        if (bool) mongoDbCategorieRepository.save(categorie)
        }


        return mongoDbCategorieRepository.findById(id).get().toCategorie()

    }
}