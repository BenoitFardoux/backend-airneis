package com.bav.airneisbackend.categorie.serverside.adapter.repository

import com.bav.airneisbackend.categorie.domain.model.Categorie
import com.bav.airneisbackend.categorie.domain.port.serverside.categorie.PourRecupererCategories
import com.bav.airneisbackend.categorie.serverside.adapter.mongodb.repository.MongoDbCategorieRepository
import com.bav.airneisbackend.categorie.serverside.mapper.CategorieMapper.toCategorie
import org.springframework.stereotype.Repository


@Repository
class PourRecupererCategorieRepository(val mongoDbCategorieRepository: MongoDbCategorieRepository) : PourRecupererCategories{
    override fun invoke(): List<Categorie> {
        return mongoDbCategorieRepository.findAll().map { it.toCategorie() }
    }
}