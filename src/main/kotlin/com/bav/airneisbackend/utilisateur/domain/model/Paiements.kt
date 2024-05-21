package com.bav.airneisbackend.utilisateur.domain.model
data class Paiments(
    val numeroCarte: String,
    val dateExpiration: String,
    val codeSecurite: String,
    val nomCarte: String
)