package com.bav.airneisbackend.Materiaux.serverside.adapter.repository

import com.bav.airneisbackend.Materiaux.domain.model.Materiau
import com.bav.airneisbackend.Materiaux.domain.port.serverside.PourPersisterUnMateriau
import com.bav.airneisbackend.Materiaux.serverside.mapper.MateriauMapper.toMateriau
import com.bav.airneisbackend.Materiaux.serverside.mapper.MateriauMapper.toMateriauDocument
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.stereotype.Repository


@Repository
class PersisterMateriauRepository(val mongoTemplate: MongoTemplate) : PourPersisterUnMateriau{
    override fun invoke(materiau: Materiau): Materiau {
        val materiauDocument  = materiau.toMateriauDocument()
        return mongoTemplate.save(materiauDocument).toMateriau()
    }
}