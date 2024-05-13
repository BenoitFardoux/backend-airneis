package com.bav.airneisbackend.Materiaux.serverside.adapter.repository

import com.bav.airneisbackend.Materiaux.domain.exception.MateriauNonTrouveException
import com.bav.airneisbackend.Materiaux.domain.model.Materiau
import com.bav.airneisbackend.Materiaux.domain.port.serverside.PourRecupererUnMateriau
import com.bav.airneisbackend.Materiaux.serverside.adapter.mongodb.repository.MongoDbMateriauxRepository
import com.bav.airneisbackend.Materiaux.serverside.mapper.MateriauMapper.toMateriau
import org.springframework.stereotype.Repository
import kotlin.jvm.optionals.getOrNull


@Repository
class RecupererUnMateriauRepository(private val mongoDbMateriauxRepository: MongoDbMateriauxRepository) : PourRecupererUnMateriau {


    override fun invoke(id: String): Materiau =
        mongoDbMateriauxRepository.findById(id).getOrNull()?.toMateriau() ?: throw MateriauNonTrouveException("Le materiau n'a pas été trouvé")
}