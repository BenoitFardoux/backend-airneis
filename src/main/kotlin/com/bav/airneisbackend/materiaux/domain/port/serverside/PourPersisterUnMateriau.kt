package com.bav.airneisbackend.materiaux.domain.port.serverside

import com.bav.airneisbackend.materiaux.domain.model.Materiau

fun interface PourPersisterUnMateriau {
    operator fun invoke(materiau: Materiau) : Materiau
}