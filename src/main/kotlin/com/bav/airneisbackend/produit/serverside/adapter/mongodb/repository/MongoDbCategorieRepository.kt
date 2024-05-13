package com.bav.airneisbackend.produit.serverside.adapter.mongodb.repository

import com.bav.airneisbackend.produit.serverside.dto.CategorieDocument
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository


@Repository
interface MongoDbCategorieRepository: MongoRepository<CategorieDocument, String>