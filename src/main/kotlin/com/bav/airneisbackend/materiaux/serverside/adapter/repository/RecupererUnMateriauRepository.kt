package com.bav.airneisbackend.materiaux.serverside.adapter.repository

import com.bav.airneisbackend.materiaux.domain.exception.MateriauNonTrouveException
import com.bav.airneisbackend.materiaux.domain.model.Materiau
import com.bav.airneisbackend.materiaux.domain.port.serverside.PourRecupererUnMateriau
import com.bav.airneisbackend.materiaux.serverside.adapter.mongodb.repository.MongoDbMateriauxRepository
import com.bav.airneisbackend.materiaux.serverside.mapper.MateriauMapper.toMateriau
import org.springframework.stereotype.Repository
import kotlin.jvm.optionals.getOrNull


@Repository
class RecupererUnMateriauRepository(private val mongoDbMateriauxRepository: MongoDbMateriauxRepository) : PourRecupererUnMateriau {


    override fun invoke(id: String): Materiau =
        mongoDbMateriauxRepository.findById(id).getOrNull()?.toMateriau() ?: throw MateriauNonTrouveException(id)
}