package com.bav.airneisbackend.utilisateur.serverside.mapper

import com.bav.airneisbackend.utilisateur.domain.model.Utilisateur
import com.bav.airneisbackend.utilisateur.serverside.dto.UtilisateurDocument
import org.bson.types.ObjectId

object UtilisateurMapper {
    fun UtilisateurDocument.toUtilisateur() : Utilisateur {
        return Utilisateur(
            id = id,
            nom = nom,
            prenom = prenom,
            email = email,
            motDePasse = motDePasse,
            adresse = adresse,
            numeroDeTelephone = numeroDeTelephone,
            paiements = paiements,
            panierActuel = panierActuel,
            commandes = commandes,
            verifie = verifie
        )
    }

    fun Utilisateur.toUtilisateurDocument() : UtilisateurDocument {
        return UtilisateurDocument(
            id = id.ifBlank { ObjectId().toHexString()  },
            nom = nom,
            prenom = prenom,
            email = email,
            motDePasse = motDePasse,
            adresse = adresse,
            numeroDeTelephone = numeroDeTelephone,
            paiements = paiements,
            panierActuel = panierActuel,
            commandes = commandes,
            verifie = verifie
        )
    }
}