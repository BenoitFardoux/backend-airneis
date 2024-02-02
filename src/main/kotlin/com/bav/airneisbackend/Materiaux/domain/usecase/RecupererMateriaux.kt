package com.bav.airneisbackend.Materiaux.domain.usecase

import com.bav.airneisbackend.Materiaux.domain.model.Materiau
import com.bav.airneisbackend.Materiaux.domain.port.serverside.PourRechercherMateriauParMotCleServerSidePort
import com.bav.airneisbackend.Materiaux.domain.port.serverside.PourRecupererMateriauxServersidePort
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Component


@Component
class RecupererMateriaux(
    private val pourRecupererMateriauxServersidePort: PourRecupererMateriauxServersidePort,
    private val pourRecupererMateriauxParMotCleServersidePort: PourRechercherMateriauParMotCleServerSidePort
) {
    operator fun invoke(pageable: PageRequest, critereDeRecherche: String?): Page<Materiau> {
        return critereDeRecherche?.takeIf { it.isNotBlank() && it.isNotEmpty() }?.let {
            pourRecupererMateriauxParMotCleServersidePort.recupererMateriauxParMotCle(pageable, critereDeRecherche)
        } ?: pourRecupererMateriauxServersidePort.recupererMateriaux(pageable)
    }
}