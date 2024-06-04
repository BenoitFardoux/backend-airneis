package com.bav.airneisbackend.materiaux.domain.port.serverside

import com.bav.airneisbackend.materiaux.domain.model.Materiau

fun interface PourRecupererUnMateriau {
    operator fun invoke(id: String) : Materiau
}