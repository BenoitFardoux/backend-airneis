package com.bav.airneisbackend.utilisateur.domain.port.serverside

import com.bav.airneisbackend.utilisateur.domain.model.Utilisateur

fun interface InscriptionUtilisateurServerSidePort {
    operator fun invoke(utilisateur: Utilisateur) : Utilisateur
}