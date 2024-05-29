package com.bav.airneisbackend.utilisateur.domain.usecase

import com.bav.airneisbackend.utilisateur.domain.model.Utilisateur
import com.bav.airneisbackend.utilisateur.domain.port.serverside.AjouterArticleDansPanierUtilisateurServerSidePort
import org.springframework.stereotype.Component


@Component
class AjoutArticleDansLePanier(val ajouterArticleDansPanierUtilisateurServerSidePort: AjouterArticleDansPanierUtilisateurServerSidePort) {
    operator fun invoke(idArticle: String) : Utilisateur =
        ajouterArticleDansPanierUtilisateurServerSidePort( idArticle)

}