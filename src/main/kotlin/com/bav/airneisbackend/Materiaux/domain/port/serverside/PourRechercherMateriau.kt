package com.bav.airneisbackend.Materiaux.domain.port.serverside

import com.bav.airneisbackend.Materiaux.domain.model.Materiau
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest

fun interface PourRechercherMateriau {
    operator fun invoke(pageRequest: PageRequest, critereDeRecherche : String) : Page<Materiau>
}

