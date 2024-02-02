package com.bav.airneisbackend.Materiaux.serverside.adapter.repository

import com.bav.airneisbackend.Materiaux.domain.model.Materiau
import com.bav.airneisbackend.Materiaux.domain.port.serverside.PourRechercherMateriauParMotCleServerSidePort
import com.bav.airneisbackend.Materiaux.serverside.dto.MateriauDocument
import com.bav.airneisbackend.Materiaux.serverside.mapper.MateriauMapper.toMateriau
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Repository


@Repository
class RecupererMateriauxParMotCleRepository(val mongoTemplate: MongoTemplate) : PourRechercherMateriauParMotCleServerSidePort{
    override fun recupererMateriauxParMotCle(pageRequest: PageRequest, critereDeRecherche: String): Page<Materiau> {
        val regex = Regex(".*$critereDeRecherche.*")
        val query = Query()
        query.addCriteria(Criteria.where("name").regex(regex.toPattern()))
        return PageImpl(mongoTemplate.find(query,MateriauDocument::class.java).map { it.toMateriau() })
    }
}