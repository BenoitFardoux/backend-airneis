package com.bav.airneisbackend.airneis.serverside.adapter.repository

import com.bav.airneisbackend.airneis.domain.model.Materiau
import com.bav.airneisbackend.airneis.domain.port.serverside.PourRecupererMateriauxServersidePort
import com.bav.airneisbackend.airneis.serverside.adapter.mongodb.repository.MongoDbMateriauxRepository
import com.bav.airneisbackend.airneis.serverside.mapper.MateriauMapper.toMateriau
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Repository


@Repository
class RecupererMateriauxRepository (
    private val mongoDbMateriauxRepository: MongoDbMateriauxRepository
) : PourRecupererMateriauxServersidePort{
    override fun recupererMateriaux(pageRequest: PageRequest): Page<Materiau> {
        return mongoDbMateriauxRepository.findAll(pageRequest).map {it.toMateriau()}
    }

}