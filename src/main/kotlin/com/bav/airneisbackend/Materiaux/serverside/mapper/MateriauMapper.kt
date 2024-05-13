package com.bav.airneisbackend.Materiaux.serverside.mapper

import com.bav.airneisbackend.Materiaux.domain.model.Materiau
import com.bav.airneisbackend.Materiaux.serverside.dto.MateriauDocument
import org.bson.types.ObjectId

object MateriauMapper {
    fun MateriauDocument.toMateriau() : Materiau=
        Materiau(
            id = id,
            nom = nom,
            type = type,
            image = image
        )

    fun Materiau.toMateriauDocument() : MateriauDocument=
        MateriauDocument(
            id = id.ifEmpty { ObjectId().toHexString() },
            nom = nom,
            type = type,
            image = image
        )
}