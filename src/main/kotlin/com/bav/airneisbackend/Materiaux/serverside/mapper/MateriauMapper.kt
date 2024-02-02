package com.bav.airneisbackend.Materiaux.serverside.mapper

import com.bav.airneisbackend.Materiaux.domain.model.Materiau
import com.bav.airneisbackend.Materiaux.serverside.dto.MateriauDocument

object MateriauMapper {
    fun MateriauDocument.toMateriau() : Materiau=
        Materiau(
            id = materiauId,
            nomMateriau = name
        )
}