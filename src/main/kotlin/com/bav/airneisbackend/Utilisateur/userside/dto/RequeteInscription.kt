package com.bav.airneisbackend.utilisateur.userside.dto

data class RequeteInscription(
    val username : String,
    val nom: String,
    val prenom: String,
    val email: String,
    val motDePasse: String,
    val numeroDeTelephone : String
)
