package com.bav.airneisbackend.Utilisateur.domain.port.serverside

import com.bav.airneisbackend.Utilisateur.domain.model.Panier

interface PourRecupererPanierServerSidePort {
    fun recupererPanier(idUtilisateur: String) : Panier
}