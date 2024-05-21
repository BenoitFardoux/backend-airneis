package com.bav.airneisbackend.utilisateur.domain.model

data class Utilsateur (
    val id : String,
    val nom : String,
    val prenom : String,
    val email : String,
    val motDePasse : String,
    val adresse : String,
    val codePostal : String,
    val ville : String,
    val pays : String,
    val telephone : String,
    val panier : Panier
)