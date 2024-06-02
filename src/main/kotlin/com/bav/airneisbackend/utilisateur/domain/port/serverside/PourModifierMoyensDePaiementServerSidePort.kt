package com.bav.airneisbackend.utilisateur.domain.port.serverside

import com.bav.airneisbackend.utilisateur.domain.model.MoyenDePaiement
import com.bav.airneisbackend.utilisateur.domain.model.Utilisateur

fun interface PourModifierMoyensDePaiementServerSidePort {
    operator fun invoke(paiements : List<MoyenDePaiement>) : Utilisateur
}