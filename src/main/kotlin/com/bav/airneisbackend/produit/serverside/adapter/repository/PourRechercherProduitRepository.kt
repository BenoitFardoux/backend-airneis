package com.bav.airneisbackend.produit.serverside.adapter.repository

import com.bav.airneisbackend.Materiaux.serverside.dto.MateriauDocument
import com.bav.airneisbackend.Materiaux.serverside.mapper.MateriauMapper.toMateriau
import com.bav.airneisbackend.produit.domain.model.Produit
import com.bav.airneisbackend.produit.domain.port.serverside.produit.RechercherProduit
import com.bav.airneisbackend.produit.serverside.dto.ProduitDocument
import com.bav.airneisbackend.produit.serverside.mapper.ProduitMapper.toProduit
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Repository


@Repository
class PourRechercherProduitRepository(val mongoTemplate: MongoTemplate) : RechercherProduit {

    override fun invoke(pageable: Pageable, critereDeRecherche: String): Page<Produit> {
        val regex = Regex(".*$critereDeRecherche.*", RegexOption.IGNORE_CASE)
        val query = Query()
        query.addCriteria(Criteria.where("nom").regex(regex.toPattern()))
        val produitRecupere: List<ProduitDocument> = mongoTemplate.find(query, ProduitDocument::class.java)
        val materiaux = produitRecupere.map { it.toProduit() }
        return PageImpl(materiaux,pageable,produitRecupere.size.toLong())
    }
}