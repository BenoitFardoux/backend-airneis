package com.bav.airneisbackend.produit.serverside.adapter.repository

import com.bav.airneisbackend.produit.domain.exception.AucunProduitTrouveException
import com.bav.airneisbackend.produit.domain.model.Produit
import com.bav.airneisbackend.produit.domain.port.serverside.produit.PourRecupererProduitParId
import com.bav.airneisbackend.produit.serverside.adapter.mongodb.repository.MongoDbProduitRepository
import com.bav.airneisbackend.produit.serverside.mapper.ProduitMapper.toProduit
import org.springframework.stereotype.Repository
import kotlin.jvm.optionals.getOrElse


@Repository
class PourRecupererUnProduitRepository(private val mongoDbProduitRepository: MongoDbProduitRepository) : PourRecupererProduitParId {
    override operator fun invoke(id: String): Produit {
        return mongoDbProduitRepository.findById(id).getOrElse { throw AucunProduitTrouveException("Produit $id non trouvé") }
            .toProduit()
    }
}