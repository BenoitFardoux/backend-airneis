package com.bav.airneisbackend.utilisateur.domain.usecase

import com.bav.airneisbackend.utilisateur.domain.port.serverside.PourSIncrireServerSidePort
import org.springframework.stereotype.Component

@Component
class SIncrire(val pourSinscrire: PourSIncrireServerSidePort) {
    operator fun invoke(email: String, motDePasse: String) = pourSinscrire(email, motDePasse)
}