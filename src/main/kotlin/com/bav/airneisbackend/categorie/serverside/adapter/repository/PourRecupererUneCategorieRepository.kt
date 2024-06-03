package com.bav.airneisbackend.categorie.serverside.adapter.repository

import com.bav.airneisbackend.categorie.domain.model.Categorie
import com.bav.airneisbackend.categorie.domain.port.serverside.categorie.PourRecupererUneCategorie
import com.bav.airneisbackend.categorie.serverside.adapter.mongodb.repository.MongoDbCategorieRepository
import org.springframework.stereotype.Repository


@Repository
class PourRecupererUneCategorieRepository(val mongoDbCategorieRepository: MongoDbCategorieRepository) : PourRecupererUneCategorie {
    override fun invoke(id: String): Categorie {
        if (mongoDbCategorieRepository.existsById(id).not()) {
            throw Exception("Categorie not found")
        }
        val categorie = mongoDbCategorieRepository.findById(id).get()

        TODO("Not yet implemented")
    }
}