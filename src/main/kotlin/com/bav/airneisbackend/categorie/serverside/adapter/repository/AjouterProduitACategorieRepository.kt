package com.bav.airneisbackend.categorie.serverside.adapter.repository

import com.bav.airneisbackend.categorie.serverside.adapter.mongodb.repository.MongoDbCategorieRepository
import com.bav.airneisbackend.categorie.domain.model.Categorie
import com.bav.airneisbackend.categorie.domain.model.Produit
import com.bav.airneisbackend.categorie.serverside.dto.CategorieDocument
import com.bav.airneisbackend.categorie.serverside.mapper.CategorieMapper.toCategorie
import org.springframework.stereotype.Repository

@Repository
class AjouterProduitACategorieRepository(val mongoDbCategorieRepository: MongoDbCategorieRepository) {
    operator fun invoke(idCategorie: String, idProduit: String): Categorie {
        if (idCategorie.isEmpty()) {
            throw IllegalArgumentException("L'id de la catégorie ne doit pas être vide")
        }
        if (idProduit.isEmpty()) {
            throw IllegalArgumentException("L'id du produit ne doit pas être vide")
        }

        val categorie: CategorieDocument = mongoDbCategorieRepository.findById(idCategorie).get()
        categorie.produits.add(Produit(idProduit))
        return mongoDbCategorieRepository.save(categorie).toCategorie()
    }
}