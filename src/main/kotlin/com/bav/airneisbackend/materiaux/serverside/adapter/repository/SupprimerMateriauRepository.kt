package com.bav.airneisbackend.materiaux.serverside.adapter.repository

import com.bav.airneisbackend.materiaux.domain.exception.MateriauNonTrouveException
import com.bav.airneisbackend.materiaux.domain.port.serverside.PourSupprimerMateriauServerSidePort
import com.bav.airneisbackend.materiaux.serverside.adapter.mongodb.repository.MongoDbMateriauxRepository
import com.bav.airneisbackend.materiaux.serverside.mapper.MateriauMapper.toMateriau
import com.bav.airneisbackend.materiaux.domain.model.Materiau
import org.springframework.stereotype.Repository
import kotlin.jvm.optionals.getOrElse


@Repository
class SupprimerMateriauRepository (val mongoDbMateriauxRepository: MongoDbMateriauxRepository): PourSupprimerMateriauServerSidePort {
    override fun invoke(id : String): Materiau {
        val materiau = mongoDbMateriauxRepository.findById(id).getOrElse { throw MateriauNonTrouveException(id) }
        mongoDbMateriauxRepository.delete(materiau)
        return materiau.toMateriau()
    }
}