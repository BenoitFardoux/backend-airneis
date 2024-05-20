package com.bav.airneisbackend.utilisateur.userside.mapper

import com.bav.airneisbackend.utilisateur.domain.model.Panier
import com.bav.airneisbackend.utilisateur.domain.model.Utilisateur
import com.bav.airneisbackend.utilisateur.userside.dto.RequeteInscription
import org.bson.types.ObjectId
import java.util.Objects

object UtilisateurMapper {
    fun RequeteInscription.toUtilisateur(): Utilisateur = Utilisateur(
        nom = nom,
        prenom = prenom,
        email = email,
        password = motDePasse,
        numeroDeTelephone = numeroDeTelephone,
        username = username,
        verifie = false,
        paiements = emptyList(),
        panierActuel = Panier(id = ObjectId().toHexString(), produits = emptyList())

    )


}