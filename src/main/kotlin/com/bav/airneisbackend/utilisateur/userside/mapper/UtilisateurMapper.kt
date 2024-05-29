package com.bav.airneisbackend.utilisateur.userside.mapper

import com.bav.airneisbackend.utilisateur.domain.model.Panier
import com.bav.airneisbackend.utilisateur.domain.model.Utilisateur
import com.bav.airneisbackend.utilisateur.userside.restressource.InscriptionUtilisateurRestRessource
import com.bav.airneisbackend.utilisateur.userside.restressource.UtilisateurRestRessource

object UtilisateurMapper {
    fun Utilisateur.toUtilisateurRestRessource() : UtilisateurRestRessource {
        return UtilisateurRestRessource(
            email = email,
            motDePasse = motDePasse,
            nom = nom,
            numeroDeTelephone = numeroDeTelephone,
            prenom = prenom,
            verifie = verifie,
            paiements = paiements,
            adresse = adresse,
            panierActuel = panierActuel,
            commandes = commandes,


        )
    }
    fun InscriptionUtilisateurRestRessource.toUtilisateur() : Utilisateur {
        return Utilisateur(
            email = email,
            motDePasse = motDePasse,
            nom = nom,
            adresse = emptyList(),
            numeroDeTelephone = telephone,
            paiements = emptyList(),
            panierActuel = Panier(
                produits = emptyList(),
                id = ""
            ),
            commandes = emptyList(),
            verifie = false,
            prenom = prenom,
            id = ""
        )
    }
}