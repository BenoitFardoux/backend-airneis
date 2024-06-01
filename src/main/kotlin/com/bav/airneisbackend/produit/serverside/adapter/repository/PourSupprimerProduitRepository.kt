package com.bav.airneisbackend.produit.serverside.adapter.repository

import com.bav.airneisbackend.produit.domain.model.Produit
import com.bav.airneisbackend.produit.domain.port.serverside.produit.PourSupprimerProduit
import com.bav.airneisbackend.produit.serverside.adapter.mongodb.repository.MongoDbProduitRepository
import com.bav.airneisbackend.produit.serverside.exception.ProduitIntrouvableException
import com.bav.airneisbackend.produit.serverside.mapper.ProduitMapper.toProduit
import org.springframework.stereotype.Repository


@Repository
class PourSupprimerProduitRepository(val mongoDbProduitRepository: MongoDbProduitRepository) : PourSupprimerProduit {
    override fun invoke(id: String): Produit {
        mongoDbProduitRepository.existsById(id).takeIf { it }?.let {

            val produit = mongoDbProduitRepository.findById(id).get()
            mongoDbProduitRepository.deleteById(id)
            return produit.toProduit()
        } ?: throw ProduitIntrouvableException("Le produit avec l'id $id n'existe pas")
    }
}