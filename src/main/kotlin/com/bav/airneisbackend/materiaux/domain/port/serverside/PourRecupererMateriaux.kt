package com.bav.airneisbackend.materiaux.domain.port.serverside

import com.bav.airneisbackend.materiaux.domain.model.Materiau
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest

fun interface PourRecupererMateriaux {
    operator fun invoke(pageRequest: PageRequest) : Page<Materiau>
}