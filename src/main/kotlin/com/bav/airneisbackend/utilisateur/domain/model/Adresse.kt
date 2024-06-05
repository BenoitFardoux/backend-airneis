package com.bav.airneisbackend.utilisateur.domain.model

import com.bav.airneisbackend.utilisateur.serverside.exception.AdresseInvalideException

data class Adresse(
    val codePostal: String,
    val numeroDeRue: String,
    val informations: String,
    val ville: String,
    val pays: String,
    val telephone: String,
    val prenom: String,
    val nom: String,
) {
    fun estValide(): Boolean {
        return verifierCodePostal() &&
                verifierNumeroDeRue() &&
                verifierInformations() &&
                verifierVille() &&
                verifierPays() &&
                verifierTelephone() &&
                verifierPrenom() &&
                verifierNom()}

    private fun verifierCodePostal(): Boolean {
        val codePostalRegex = Regex("^[0-9]{5}\$")
        if (!codePostalRegex.matches(codePostal)) {
            throw AdresseInvalideException(mutableListOf("Code postal"))
        }
        return true
    }

    private fun verifierNumeroDeRue(): Boolean {
        // regex numero et nom de rue
        val numeroDeRueRegex = Regex("^[0-9]+[A-Za-z\\s\\-]*\$")
        if (!numeroDeRueRegex.matches(numeroDeRue)) {
            throw AdresseInvalideException(mutableListOf("Numéro de rue"))
        }
        return true
    }

    private fun verifierInformations(): Boolean {
        // Supposons que les informations supplémentaires peuvent être vides
        return true
    }

    private fun verifierVille(): Boolean {
        val villeRegex = Regex("^[A-Za-z\\s\\-]+\$")
        if (!villeRegex.matches(ville)) {
            throw AdresseInvalideException(mutableListOf("Ville"))
        }
        return true
    }

    private fun verifierPays(): Boolean {
        val paysRegex = Regex("^[A-Za-z\\s\\-]+\$")
        if (!paysRegex.matches(pays)) {
            throw AdresseInvalideException(mutableListOf("Pays"))
        }
        return true
    }

    private fun verifierTelephone(): Boolean {
        val telephoneRegex = Regex("^[0-9\\s]{10,15}\$")
        if (!telephoneRegex.matches(telephone)) {
            throw AdresseInvalideException(mutableListOf("Numéro de téléphone"))
        }
        return true
    }

    private fun verifierPrenom(): Boolean {
        // prenom avec accents
        val prenomRegex = Regex("^[A-Za-zÀ-ÿ\\s\\-]+\$")
        if (!prenomRegex.matches(prenom)) {
            throw AdresseInvalideException(mutableListOf(("Prénom")))
        }
        return true
    }

    private fun verifierNom(): Boolean {
        val nomRegex = Regex("^[A-Za-z\\s\\-]+\$")
        if (!nomRegex.matches(nom)) {
            throw AdresseInvalideException(mutableListOf("Nom invalide"))
        }
        return true
    }

}
