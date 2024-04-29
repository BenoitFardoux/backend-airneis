package com.bav.airneisbackend.Materiaux.domain.usecase

import com.bav.airneisbackend.Materiaux.domain.model.Materiau
import com.bav.airneisbackend.Materiaux.domain.port.serverside.PourRechercherMateriau
import com.bav.airneisbackend.Materiaux.domain.port.serverside.PourRecupererMateriaux
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Component


@Component
class RecupererMateriaux(
    private val pourRecupererMateriaux: PourRecupererMateriaux,
    private val pourRecupererMateriauxParMotCleServersidePort: PourRechercherMateriau
) {
    operator fun invoke(pageable: PageRequest, critereDeRecherche: String?): Page<Materiau> {
        return critereDeRecherche?.takeIf { it.isNotBlank() && it.isNotEmpty() }?.let {
            pourRecupererMateriauxParMotCleServersidePort(pageable, critereDeRecherche)
        } ?: pourRecupererMateriaux(pageable)
    }
}