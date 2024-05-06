package com.bav.airneisbackend.Produit.serverside.adapter.mongodb.repository

import com.bav.airneisbackend.Produit.serverside.dto.ProduitDocument
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository


@Repository
interface MongoDbProduitRepository: MongoRepository<ProduitDocument, String>