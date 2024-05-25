package com.bav.airneisbackend.utilisateur.domain.model
data class Paiements(
    val numeroCarte: String,
    val dateExpiration: String,
    val codeSecurite: String,
    val nomCarte: String
)