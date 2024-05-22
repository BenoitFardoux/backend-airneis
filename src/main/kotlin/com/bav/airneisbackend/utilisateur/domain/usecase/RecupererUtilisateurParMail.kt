package com.bav.airneisbackend.utilisateur.domain.usecase

import com.bav.airneisbackend.utilisateur.domain.model.Utilisateur
import com.bav.airneisbackend.utilisateur.domain.port.serverside.PourRecupererUtilisateurParMailServerSidePort
import org.springframework.stereotype.Component


@Component
class RecupererUtilisateurParMail(
    val pourRecupererUtilisateurParMailServerSidePort: PourRecupererUtilisateurParMailServerSidePort
) {
    operator fun invoke(mail: String): Utilisateur = pourRecupererUtilisateurParMailServerSidePort(mail)
}