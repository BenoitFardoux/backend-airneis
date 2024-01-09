package com.bav.airneisbackend.airneis.serverside.mapper

import com.bav.airneisbackend.airneis.domain.model.Materiau
import com.bav.airneisbackend.airneis.serverside.dto.MateriauDocument

object MateriauMapper {
    fun MateriauDocument.toMateriau() : Materiau=
        Materiau(
            id = id,
            nomMateriau = name
        )
}