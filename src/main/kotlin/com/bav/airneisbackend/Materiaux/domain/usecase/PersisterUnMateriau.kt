package com.bav.airneisbackend.Materiaux.domain.usecase

import com.bav.airneisbackend.Materiaux.domain.model.Materiau
import com.bav.airneisbackend.Materiaux.domain.port.serverside.PourPersisterUnMateriau
import org.springframework.stereotype.Component

@Component
class PersisterUnMateriau(private val pourPersisterUnMateriau: PourPersisterUnMateriau) {
    operator fun invoke(materiau: Materiau) = pourPersisterUnMateriau(materiau)
}