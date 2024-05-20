package com.bav.airneisbackend.utilisateur.domain.usecase

import com.bav.airneisbackend.utilisateur.domain.model.Utilisateur
import com.bav.airneisbackend.utilisateur.domain.port.serverside.PourSeConnecterServerSidePort
import org.springframework.stereotype.Component


@Component
class SeConnecter(val pourSeConnecterServerSidePort: PourSeConnecterServerSidePort) {
    operator fun invoke(utilisateur: Utilisateur) = pourSeConnecterServerSidePort(utilisateur)
}