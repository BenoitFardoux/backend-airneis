package com.bav.airneisbackend.airneis.serverside.adapter.mongodb.repository

import com.bav.airneisbackend.airneis.serverside.dto.ReferentielDeMateriauDocument
import com.bav.airneisbackend.airneis.userside.adaptater.controller.ReferentielDeMateriauController
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface MongoDbReferentielDeMateriauRepository : MongoRepository<ReferentielDeMateriauDocument, String> {
}