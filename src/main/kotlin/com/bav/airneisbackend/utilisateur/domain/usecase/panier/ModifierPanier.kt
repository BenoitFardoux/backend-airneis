package com.bav.airneisbackend.utilisateur.domain.usecase.panier

import com.bav.airneisbackend.utilisateur.domain.model.Panier
import com.bav.airneisbackend.utilisateur.domain.model.Utilisateur
import com.bav.airneisbackend.utilisateur.domain.port.serverside.ModifierPanierServerSidePort
import org.springframework.stereotype.Component


@Component
class ModifierPanier(private val modifierPanierServerSidePort: ModifierPanierServerSidePort) {
    operator fun invoke(panier : Panier) : Utilisateur = modifierPanierServerSidePort(panier)
}