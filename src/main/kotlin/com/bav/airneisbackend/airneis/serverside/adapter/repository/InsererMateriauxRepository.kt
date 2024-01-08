package com.bav.airneisbackend.airneis.serverside.adapter.repository

import com.bav.airneisbackend.airneis.domain.port.serverside.PourInsererMateriauxServerSidePort
import com.bav.airneisbackend.airneis.domain.usecase.InsererMateriaux
import com.bav.airneisbackend.airneis.serverside.adapter.mongodb.repository.MongoDbReferentielDeMateriauRepository
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.stereotype.Repository


@Repository
class InsererMateriauxRepository (
    private val mongoDbReferentielDeMateriauRepository : MongoDbReferentielDeMateriauRepository,
    private val mongoTemplate: MongoTemplate
) : PourInsererMateriauxServerSidePort{
    override fun insererMateriaux(): Int {
        TODO("Not yet implemented")
    }
}