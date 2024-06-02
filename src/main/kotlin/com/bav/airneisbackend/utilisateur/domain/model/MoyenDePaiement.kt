package com.bav.airneisbackend.utilisateur.domain.model
data class MoyenDePaiement(
    val numeroCarte: String,
    val dateExpiration: String,
    val codeSecurite: String,
    val nomCarte: String,
    val estParDefaut : Boolean = false
)