package com.bav.airneisbackend.utilisateur.domain.usecase.panier

import com.bav.airneisbackend.utilisateur.domain.model.Utilisateur
import com.bav.airneisbackend.utilisateur.domain.port.serverside.AjouterArticleDansPanierUtilisateurServerSidePort
import org.springframework.stereotype.Component


@Component
class AjoutArticleDansLePanier(val ajouterArticleDansPanierUtilisateurServerSidePort: AjouterArticleDansPanierUtilisateurServerSidePort) {
    operator fun invoke(idArticle: String, quantite :Int) : Utilisateur
    {
        when {
            quantite <= 0 -> {
                throw IllegalArgumentException("La quantité doit être positive")
            }
            else -> return ajouterArticleDansPanierUtilisateurServerSidePort(idArticle, quantite)
        }
    }


}
