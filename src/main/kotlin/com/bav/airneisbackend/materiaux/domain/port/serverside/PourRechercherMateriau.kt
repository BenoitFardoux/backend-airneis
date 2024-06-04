package com.bav.airneisbackend.materiaux.domain.port.serverside

import com.bav.airneisbackend.materiaux.domain.model.Materiau
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest

fun interface PourRechercherMateriau {
    operator fun invoke(pageRequest: PageRequest, critereDeRecherche : String) : Page<Materiau>
}

