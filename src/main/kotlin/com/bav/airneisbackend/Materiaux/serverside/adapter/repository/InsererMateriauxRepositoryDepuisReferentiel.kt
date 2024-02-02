package com.bav.airneisbackend.Materiaux.serverside.adapter.repository

import com.bav.airneisbackend.Materiaux.domain.port.serverside.PourInsererMateriauxDepuisReferentielServerSidePort
import com.bav.airneisbackend.Materiaux.serverside.adapter.mongodb.repository.MongoDbReferentielDeMateriauRepository
import com.bav.airneisbackend.Materiaux.serverside.mapper.MateriauDocumentMapper
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