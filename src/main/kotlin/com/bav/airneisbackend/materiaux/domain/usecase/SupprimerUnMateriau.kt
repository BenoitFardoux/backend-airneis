package com.bav.airneisbackend.materiaux.domain.usecase

import com.bav.airneisbackend.materiaux.domain.port.serverside.PourSupprimerMateriauServerSidePort
import org.springframework.stereotype.Service


@Service
class SupprimerUnMateriau (val pourSupprimerMateriauServerSidePort: PourSupprimerMateriauServerSidePort){
    operator fun invoke(idMateriau: String) = pourSupprimerMateriauServerSidePort(idMateriau)
}