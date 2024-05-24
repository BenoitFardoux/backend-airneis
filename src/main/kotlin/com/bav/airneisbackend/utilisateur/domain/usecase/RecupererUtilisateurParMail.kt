package com.bav.airneisbackend.utilisateur.domain.usecase

import com.bav.airneisbackend.utilisateur.domain.model.Utilisateur
import com.bav.airneisbackend.utilisateur.domain.port.serverside.PourRecupererUtilisateurParMailServerSidePort
import com.bav.airneisbackend.utilisateur.serverside.exception.AdresseMailException
import com.bav.airneisbackend.utils.Utils
import org.springframework.stereotype.Component


@Component
class RecupererUtilisateurParMail(
    val pourRecupererUtilisateurParMailServerSidePort: PourRecupererUtilisateurParMailServerSidePort
) {
    operator fun invoke(mail: String): Utilisateur = mail.takeIf { Utils.isEmailValid(it) } ?.let { pourRecupererUtilisateurParMailServerSidePort(it) } ?: throw AdresseMailException()
}