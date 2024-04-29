package com.bav.airneisbackend.Materiaux.domain.port.serverside

import com.bav.airneisbackend.Materiaux.domain.model.Materiau

fun interface PourPersisterUnMateriau {
    operator fun invoke(materiau: Materiau) : Materiau
}