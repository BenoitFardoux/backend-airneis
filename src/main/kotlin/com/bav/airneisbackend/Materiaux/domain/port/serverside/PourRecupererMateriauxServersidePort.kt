package com.bav.airneisbackend.Materiaux.domain.port.serverside

import com.bav.airneisbackend.Materiaux.domain.model.Materiau
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest

interface PourRecupererMateriauxServersidePort {
    fun recupererMateriaux(pageRequest: PageRequest) : Page<Materiau>
}