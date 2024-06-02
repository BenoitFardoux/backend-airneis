package com.bav.airneisbackend.utilisateur.userside.restressource

data class MoyenDePaiementUtilisateursRestRessource(
    val numeroCarte: String,
    val dateExpiration: String,
    val codeSecurite: String,
    val nomCarte: String,
    val estParDefaut : Boolean = false
)
