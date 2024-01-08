package com.bav.airneisbackend.airneis.serverside.adapter.mongodb.repository

import com.bav.airneisbackend.airneis.domain.model.Materiau
import com.bav.airneisbackend.airneis.serverside.dto.MateriauDocument
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository


@Repository
interface MongoDbMateriauxRepository : MongoRepository<MateriauDocument, String>{
}