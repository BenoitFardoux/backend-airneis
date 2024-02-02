package com.bav.airneisbackend.Materiaux.serverside.adapter.repository

import com.bav.airneisbackend.Materiaux.domain.model.Materiau
import com.bav.airneisbackend.Materiaux.domain.port.serverside.PourRecupererMateriauxServersidePort
import com.bav.airneisbackend.Materiaux.serverside.adapter.mongodb.repository.MongoDbMateriauxRepository
import com.bav.airneisbackend.Materiaux.serverside.mapper.MateriauMapper.toMateriau
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