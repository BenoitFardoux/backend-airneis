package com.bav.airneisbackend.utilisateur.domain.port.serverside

import com.bav.airneisbackend.utilisateur.domain.model.Panier
import com.bav.airneisbackend.utilisateur.domain.model.Utilisateur

fun interface ModifierPanierServerSidePort {
    operator fun invoke(panier : Panier) : Utilisateur
}