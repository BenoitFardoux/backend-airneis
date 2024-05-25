package com.bav.airneisbackend.utilisateur.domain.port.serverside

import com.bav.airneisbackend.utilisateur.domain.model.Panier

interface PourRecupererPanierServerSidePort {
    fun recupererPanier(idUtilisateur: String) : Panier
}