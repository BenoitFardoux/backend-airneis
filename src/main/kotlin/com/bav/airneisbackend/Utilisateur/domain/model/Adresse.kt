package com.bav.airneisbackend.Utilisateur.domain.model
data class Adresse(
    val codePostal: String,
    val numeroDeRue: String,
    val informations:  String,
    val ville: String,
    val departement : String
)