package com.bav.airneisbackend.utilisateur.domain.port.serverside

fun interface PourConnecterUtilisateurServerSidePort {
    operator fun invoke(username: String, password: String): String
}