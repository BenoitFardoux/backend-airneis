package com.bav.airneisbackend.utilisateur.domain.model

data class Adresse(
    val codePostal: String,
    val numeroDeRue: String,
    val informations: String,
    val ville: String,
    val pays: String,
    val telephone: String,
    val prenom: String,
    val nom: String,
    val departement: String
)