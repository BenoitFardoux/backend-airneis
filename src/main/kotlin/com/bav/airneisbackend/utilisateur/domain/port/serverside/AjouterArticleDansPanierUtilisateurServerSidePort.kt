package com.bav.airneisbackend.utilisateur.domain.port.serverside

import com.bav.airneisbackend.utilisateur.domain.model.Utilisateur


fun interface AjouterArticleDansPanierUtilisateurServerSidePort {
    operator fun invoke(idArticle: String, quantite : Int) : Utilisateur
}