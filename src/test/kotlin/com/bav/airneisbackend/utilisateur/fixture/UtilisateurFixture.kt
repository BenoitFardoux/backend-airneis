package com.bav.airneisbackend.utilisateur.fixture

import com.bav.airneisbackend.utilisateur.domain.model.Panier
import com.bav.airneisbackend.utilisateur.domain.model.Utilisateur
import com.bav.airneisbackend.utilisateur.domain.model.produits.Produit
import com.bav.airneisbackend.utilisateur.serverside.dto.UtilisateurDocument

class UtilisateurFixture {
    companion object {
        val adresseMail = "baptistevannesson@gmail.com"
        val adresseMailInvalide = "baptistevannesson"
        val motDePasse = "@MotDePasse1234"
        val produit = Produit(
            id = "123456",
            quantite = 1
        )
        val panier = Panier(
            id = "123456",
            produits = mutableListOf()
        )
        val utilisateur = Utilisateur(
            id = "123456",
            nom = "Baptiste",
            prenom = "Vannesson",
            email = adresseMail,
            motDePasse = motDePasse,
            adresse = emptyList(),
            numeroDeTelephone = "",
            paiements = emptyList(),
            panierActuel = panier,
            commandes = emptyList(),
            verifie = false
        )
        val utilisateurDocument = UtilisateurDocument(
            id = "123456",
            nom = "Baptiste",
            prenom = "Vannesson",
            email = adresseMail,
            motDePasse = motDePasse,
            adresse = emptyList(),
            numeroDeTelephone = "",
            paiements = emptyList(),
            panierActuel = panier,
            commandes = emptyList(),
            verifie = false
        )
    }
}