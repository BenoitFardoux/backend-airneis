package com.bav.airneisbackend.Materiaux.domain.port.serverside

import com.bav.airneisbackend.Materiaux.domain.model.Materiau

fun interface PourRecupererUnMateriau {
    operator fun invoke(id: String) : Materiau
}