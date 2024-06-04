package com.bav.airneisbackend.utilisateur.fixture

import com.bav.airneisbackend.utilisateur.domain.model.MoyenDePaiement
import com.bav.airneisbackend.utilisateur.domain.model.Panier
import com.bav.airneisbackend.utilisateur.domain.model.Utilisateur
import com.bav.airneisbackend.utilisateur.domain.model.produits.Produit
import com.bav.airneisbackend.utilisateur.serverside.dto.UtilisateurDocument
import com.bav.airneisbackend.utilisateur.userside.restressource.MoyenDePaiementUtilisateursRestRessource
import com.bav.airneisbackend.utilisateur.userside.restressource.MoyensDePaiementUtilisateursRestRessource

class UtilisateurFixture {
    companion object {
        val adresseMail = "baptistevannesson@gmail.com"
        val adresseMailInvalide = "baptistevannesson"
        val motDePasse = "@MotDePasse1234"

        val numeroCarte = "1234567890123456"
        val dateExpiration = "12/23"
        val codeSecurite = "123"
        val nomCarte = "Baptiste Vannesson"

        val MoyenDePaiementUtilisateursRestRessource = MoyenDePaiementUtilisateursRestRessource(
            numeroCarte = numeroCarte,
            dateExpiration = dateExpiration,
            codeSecurite = codeSecurite,
            nomCarte = nomCarte
        )
        val moyensDePaiementUtilisateursRestRessource = MoyensDePaiementUtilisateursRestRessource(
            cartes = mutableListOf(MoyenDePaiementUtilisateursRestRessource)
        )

        val paiements = MoyenDePaiement(
            numeroCarte = numeroCarte,
            dateExpiration = dateExpiration,
            codeSecurite = codeSecurite,
            nomCarte = nomCarte
        )

        val produit = Produit(
            id = "123456",
            quantite = 1
        )
        val panier = Panier(
            id = "123456",
            produits = mutableListOf(produit)
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
            commandes = mutableListOf(),
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
            commandes = mutableListOf(),
            verifie = false
        )
    }
}