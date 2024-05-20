package com.bav.airneisbackend.utilisateur.domain.model

data class Utilisateur (
    val id : String = "",
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