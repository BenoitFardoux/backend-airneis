package com.bav.airneisbackend.airneis.serverside.adapter.repository

import com.bav.airneisbackend.airneis.domain.port.serverside.PourInsererMateriauxDepuisReferentielServerSidePort
import com.bav.airneisbackend.airneis.serverside.adapter.mongodb.repository.MongoDbReferentielDeMateriauRepository
import com.bav.airneisbackend.airneis.serverside.dto.MateriauDocument
import com.bav.airneisbackend.airneis.serverside.mapper.MateriauDocumentMapper
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.stereotype.Repository


@Repository
class InsererMateriauxRepositoryDepuisReferentiel(
    private val mongoDbReferentielDeMateriauRepository: MongoDbReferentielDeMateriauRepository,
    private val mongoTemplate: MongoTemplate
) : PourInsererMateriauxDepuisReferentielServerSidePort {
    override fun insererMateriaux(): Int {
        val referentielDeMateriauxDocument = mongoDbReferentielDeMateriauRepository.findAll()
        val materiauDocument = MateriauDocumentMapper.toMateriauDocument(referentielDeMateriauxDocument)
        return mongoTemplate.insertAll(materiauDocument).size
    }
}