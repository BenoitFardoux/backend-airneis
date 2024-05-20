package com.bav.airneisbackend.utilisateur.serverside.dto

import com.bav.airneisbackend.utilisateur.domain.model.Adresse
import com.bav.airneisbackend.utilisateur.domain.model.Paiments
import com.bav.airneisbackend.utilisateur.domain.model.Panier
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.MongoId


@Document(collection = "utilisateurs")
data class UtilisateurDocument(
    @MongoId val id: String = "",
    val username: String,
    val password: String,
    val verifie : Boolean,
    val email: String,
    val nom : String,
    val prenom : String,
    val paiements : List<Paiments> = emptyList(),
    val numeroDeTelephone : String,
    val addresse : List<Adresse> = emptyList(),
    val panierActuel : Panier,
    val commandes : List<Panier> = emptyList()
    )
