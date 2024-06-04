package com.bav.airneisbackend.utilisateur.domain.model

data class Utilisateur (
    val id : String,
    val verifie : Boolean,
    val motDePasse : String,
    val email: String,
    val nom : String,
    val prenom : String,
    val paiements : List<MoyenDePaiement>,
    val numeroDeTelephone : String,
    val adresse : List<Adresse>,
    val panierActuel : Panier,
    val commandes : MutableList<Panier>
)