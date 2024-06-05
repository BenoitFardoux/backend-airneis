package com.bav.airneisbackend.materiaux.domain.port.serverside

import com.bav.airneisbackend.materiaux.domain.model.Materiau

fun interface PourSupprimerMateriauServerSidePort {
    operator fun invoke(id : String) : Materiau
}