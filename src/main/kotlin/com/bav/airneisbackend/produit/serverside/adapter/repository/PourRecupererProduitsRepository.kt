package com.bav.airneisbackend.produit.serverside.adapter.repository

import com.bav.airneisbackend.produit.domain.model.Produit
import com.bav.airneisbackend.produit.domain.port.serverside.produit.PourRecupererProduitsServersidePort
import com.bav.airneisbackend.produit.serverside.adapter.mongodb.repository.MongoDbProduitRepository
import com.bav.airneisbackend.produit.serverside.mapper.ProduitMapper.toProduit
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Repository

@Repository
class PourRecupererProduitsRepository(val mongoDbProduitRepository: MongoDbProduitRepository) :
    PourRecupererProduitsServersidePort {
    override operator fun invoke(pageable: Pageable): Page<Produit> =
        mongoDbProduitRepository.findAll(pageable).map { it.toProduit() }
}