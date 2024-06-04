package com.bav.airneisbackend.utilisateur.domain.usecase.utilisateur

import com.bav.airneisbackend.utilisateur.domain.model.Utilisateur
import com.bav.airneisbackend.utilisateur.domain.port.serverside.ConnexionUtilisateurServerSidePort
import com.bav.airneisbackend.utilisateur.serverside.exception.AdresseMailException
import com.bav.airneisbackend.utils.Utils
import org.springframework.stereotype.Component


@Component
class ConnexionUtilisateur(
    val pourRecupererUtilisateurParMailServerSidePort: ConnexionUtilisateurServerSidePort
) {
    operator fun invoke(mail: String, password : String): Utilisateur = mail.takeIf { Utils.isEmailValid(it) } ?.let { pourRecupererUtilisateurParMailServerSidePort(it, password) } ?: throw AdresseMailException()
}