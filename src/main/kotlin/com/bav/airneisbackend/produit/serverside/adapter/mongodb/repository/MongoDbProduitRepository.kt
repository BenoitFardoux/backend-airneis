package com.bav.airneisbackend.produit.serverside.adapter.mongodb.repository

import com.bav.airneisbackend.produit.serverside.dto.ProduitDocument
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository


@Repository
interface MongoDbProduitRepository: MongoRepository<ProduitDocument, String>