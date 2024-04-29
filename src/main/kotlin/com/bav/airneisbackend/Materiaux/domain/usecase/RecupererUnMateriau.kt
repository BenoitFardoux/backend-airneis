package com.bav.airneisbackend.Materiaux.domain.usecase

import com.bav.airneisbackend.Materiaux.domain.exception.AucunMateriauTrouveException
import com.bav.airneisbackend.Materiaux.domain.exception.MateriauNonTrouveException
import com.bav.airneisbackend.Materiaux.domain.port.serverside.PourRecupererUnMateriau
import org.springframework.stereotype.Component


@Component
class RecupererUnMateriau(private val pourRecupererUnMateriau: PourRecupererUnMateriau) {
    operator fun invoke(id: String) = pourRecupererUnMateriau(id).takeIf { it != null } ?: throw MateriauNonTrouveException(id)
}