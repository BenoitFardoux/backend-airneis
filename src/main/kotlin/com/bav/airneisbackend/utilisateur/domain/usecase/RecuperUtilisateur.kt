package com.bav.airneisbackend.utilisateur.domain.usecase

import com.bav.airneisbackend.utilisateur.domain.port.serverside.PourRecupererUtilisateurServerSidePort
import org.springframework.stereotype.Component


@Component
class RecuperUtilisateur(val pourRecupererUtilisateurServerSidePort: PourRecupererUtilisateurServerSidePort) {
    operator fun invoke() = pourRecupererUtilisateurServerSidePort()
}