package com.bav.airneisbackend.materiaux.serverside.mapper

import com.bav.airneisbackend.materiaux.domain.model.Materiau
import com.bav.airneisbackend.materiaux.serverside.dto.MateriauDocument
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