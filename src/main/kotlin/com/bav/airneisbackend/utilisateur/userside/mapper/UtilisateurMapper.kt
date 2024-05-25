package com.bav.airneisbackend.utilisateur.userside.mapper

import com.bav.airneisbackend.utilisateur.domain.model.Panier
import com.bav.airneisbackend.utilisateur.domain.model.Utilisateur
import com.bav.airneisbackend.utilisateur.userside.restressource.InscriptionUtilisateurRestRessource

object UtilisateurMapper {
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