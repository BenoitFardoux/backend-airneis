package com.bav.airneisbackend.materiaux.serverside.adapter.repository

import com.bav.airneisbackend.materiaux.domain.model.Materiau
import com.bav.airneisbackend.materiaux.domain.port.serverside.PourRechercherMateriau
import com.bav.airneisbackend.materiaux.serverside.dto.MateriauDocument
import com.bav.airneisbackend.materiaux.serverside.mapper.MateriauMapper.toMateriau
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Repository


@Repository
class RecupererMateriauxParMotCleRepository(val mongoTemplate: MongoTemplate) : PourRechercherMateriau {
    override fun invoke(pageRequest: PageRequest, critereDeRecherche: String): Page<Materiau> {
        val regex = Regex(".*$critereDeRecherche.*", RegexOption.IGNORE_CASE)
        val query = Query()
        query.addCriteria(Criteria.where("nom").regex(regex.toPattern()))
        val materiauxRecupere: List<MateriauDocument> = mongoTemplate.find(query, MateriauDocument::class.java)
        val materiaux = materiauxRecupere.map { it.toMateriau() }
        return PageImpl(materiaux)
    }
}