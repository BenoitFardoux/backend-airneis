package com.bav.airneisbackend.utilisateur.domain.port.serverside

import com.bav.airneisbackend.utilisateur.domain.model.Utilisateur

fun interface PourRecupererUtilisateurParMailServerSidePort {
    operator fun invoke(email: String): Utilisateur
}