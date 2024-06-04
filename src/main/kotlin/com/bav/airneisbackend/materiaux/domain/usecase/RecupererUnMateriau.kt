package com.bav.airneisbackend.materiaux.domain.usecase

import com.bav.airneisbackend.materiaux.domain.model.Materiau
import com.bav.airneisbackend.materiaux.domain.port.serverside.PourRecupererUnMateriau
import org.springframework.stereotype.Component


@Component
class RecupererUnMateriau(private val pourRecupererUnMateriau: PourRecupererUnMateriau) {
    operator fun invoke(id: String): Materiau = pourRecupererUnMateriau(id)
}