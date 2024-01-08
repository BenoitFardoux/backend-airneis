package com.bav.airneisbackend.airneis.domain.port.serverside

import com.bav.airneisbackend.airneis.domain.model.Materiau
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest

interface PourRecupererMateriauParMotCleServerSidePort {
    fun recupererMateriauxParMotCle(pageRequest: PageRequest, critereDeRecherche : String) : Page<Materiau>
}

