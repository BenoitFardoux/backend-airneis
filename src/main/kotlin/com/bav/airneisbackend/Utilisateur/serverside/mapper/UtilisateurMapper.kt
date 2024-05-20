package com.bav.airneisbackend.utilisateur.serverside.mapper

import com.bav.airneisbackend.utilisateur.domain.model.Utilisateur
import com.bav.airneisbackend.utilisateur.serverside.dto.UtilisateurDocument
import org.bson.types.ObjectId

object UtilisateurMapper {
    fun Utilisateur.toUtilisateurDocument() : UtilisateurDocument = UtilisateurDocument(
        id = id.ifBlank { ObjectId().toHexString() },
        username = username,
        password = password,
        verifie = verifie,
        email = email,
        nom = nom,
        prenom = prenom,
        panierActuel = panierActuel,
        numeroDeTelephone = numeroDeTelephone
    )
    fun UtilisateurDocument.toUtilisateur() : Utilisateur = Utilisateur(
        id = id,
        username = username,
        password = password,
        verifie = verifie,
        email = email,
        nom = nom,
        prenom = prenom,
        panierActuel = panierActuel,
        numeroDeTelephone = numeroDeTelephone
    )
}
