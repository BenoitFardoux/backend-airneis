package com.bav.airneisbackend.Materiaux.serverside.adapter.mongodb.repository

import com.bav.airneisbackend.Materiaux.serverside.dto.ReferentielDeMateriauDocument
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface MongoDbReferentielDeMateriauRepository : MongoRepository<ReferentielDeMateriauDocument, String> {
}