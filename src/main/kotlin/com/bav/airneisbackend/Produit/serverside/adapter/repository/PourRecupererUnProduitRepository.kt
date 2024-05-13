package com.bav.airneisbackend.Produit.serverside.adapter.repository

import com.bav.airneisbackend.Produit.domain.exception.AucunProduitTrouveException
import com.bav.airneisbackend.Produit.domain.model.Produit
import com.bav.airneisbackend.Produit.domain.port.serverside.produit.PourRecupererProduitParId
import com.bav.airneisbackend.Produit.serverside.adapter.mongodb.repository.MongoDbProduitRepository
import com.bav.airneisbackend.Produit.serverside.mapper.ProduitMapper.toProduit
import org.springframework.stereotype.Repository
import kotlin.jvm.optionals.getOrNull


@Repository
class PourRecupererUnProduitRepository(private val mongoDbProduitRepository: MongoDbProduitRepository) : PourRecupererProduitParId {
    override fun invoke(id: String): Produit {
        return mongoDbProduitRepository.findById(id).getOrNull()?.toProduit() ?: throw AucunProduitTrouveException("Le materiau n'a pas été trouvé")
    }
}