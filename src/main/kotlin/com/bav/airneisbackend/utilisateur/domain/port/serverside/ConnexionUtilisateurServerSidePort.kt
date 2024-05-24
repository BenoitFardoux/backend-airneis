package com.bav.airneisbackend.utilisateur.domain.port.serverside

import com.bav.airneisbackend.utilisateur.domain.model.Utilisateur

fun interface ConnexionUtilisateurServerSidePort {
    operator fun invoke(email: String, motDePasse : String): Utilisateur
}