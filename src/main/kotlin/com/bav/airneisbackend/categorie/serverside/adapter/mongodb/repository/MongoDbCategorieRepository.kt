package com.bav.airneisbackend.categorie.serverside.adapter.mongodb.repository

import com.bav.airneisbackend.categorie.serverside.dto.CategorieDocument
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository


@Repository
interface MongoDbCategorieRepository : MongoRepository<CategorieDocument, String>