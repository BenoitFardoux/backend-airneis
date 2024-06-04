package com.bav.airneisbackend.materiaux.domain.usecase

import com.bav.airneisbackend.materiaux.domain.model.Materiau
import com.bav.airneisbackend.materiaux.domain.port.serverside.PourPersisterUnMateriau
import org.springframework.stereotype.Component

@Component
class PersisterUnMateriau(private val pourPersisterUnMateriau: PourPersisterUnMateriau) {
    operator fun invoke(materiau: Materiau) = pourPersisterUnMateriau(materiau)
}