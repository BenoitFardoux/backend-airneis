package com.bav.airneisbackend.utilisateur.domain.port.serverside

import com.bav.airneisbackend.utilisateur.domain.model.Adresse
import com.bav.airneisbackend.utilisateur.domain.model.MoyenDePaiement
import com.bav.airneisbackend.utilisateur.domain.model.Utilisateur

fun interface CommanderPanierServerSidePort {
    operator fun invoke(adresse: Adresse, moyenDePaiement: MoyenDePaiement) : Utilisateur
}