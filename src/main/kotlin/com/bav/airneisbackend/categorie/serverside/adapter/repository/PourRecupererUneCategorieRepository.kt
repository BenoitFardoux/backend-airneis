package com.bav.airneisbackend.categorie.serverside.adapter.repository

import com.bav.airneisbackend.categorie.domain.exception.CategorieNonTrouveeException
import com.bav.airneisbackend.categorie.domain.model.Categorie
import com.bav.airneisbackend.categorie.domain.port.serverside.categorie.PourRecupererUneCategorie
import com.bav.airneisbackend.categorie.serverside.adapter.mongodb.repository.MongoDbCategorieRepository
import com.bav.airneisbackend.categorie.serverside.mapper.CategorieMapper.toCategorie
import org.springframework.stereotype.Repository


@Repository
class PourRecupererUneCategorieRepository(val mongoDbCategorieRepository: MongoDbCategorieRepository) : PourRecupererUneCategorie {
    override fun invoke(id: String): Categorie {
        if (!mongoDbCategorieRepository.existsById(id)) {
            throw CategorieNonTrouveeException(id)
        }
        return mongoDbCategorieRepository.findById(id).get().toCategorie()

    }
}