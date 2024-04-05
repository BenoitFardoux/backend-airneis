package com.bav.airneisbackend.Materiaux.serverside.adapter.mongodb.repository

import com.bav.airneisbackend.Materiaux.serverside.dto.MateriauDocument
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository


@Repository
interface MongoDbMateriauxRepository : MongoRepository<MateriauDocument, String>