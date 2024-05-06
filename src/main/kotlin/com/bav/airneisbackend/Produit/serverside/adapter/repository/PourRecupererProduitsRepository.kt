package com.bav.airneisbackend.Produit.serverside.adapter.repository

import com.bav.airneisbackend.Produit.domain.model.Produit
import com.bav.airneisbackend.Produit.domain.port.serverside.produit.PourRecupererProduitsServersidePort
import com.bav.airneisbackend.Produit.serverside.adapter.mongodb.repository.MongoDbProduitRepository
import com.bav.airneisbackend.Produit.serverside.mapper.ProduitMapper.toProduit
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Repository

@Repository
class PourRecupererProduitsRepository(val mongoDbProduitRepository: MongoDbProduitRepository) :
    PourRecupererProduitsServersidePort {
    override operator fun invoke(pageable: Pageable): Page<Produit> =
        mongoDbProduitRepository.findAll(pageable).map { it.toProduit() }
}