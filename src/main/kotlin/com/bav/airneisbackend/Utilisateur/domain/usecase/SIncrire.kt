package com.bav.airneisbackend.utilisateur.domain.usecase

import com.bav.airneisbackend.utilisateur.domain.model.Utilisateur
import com.bav.airneisbackend.utilisateur.domain.port.serverside.PourSIncrireServerSidePort
import org.springframework.stereotype.Component

@Component
class SIncrire(val pourSinscrire: PourSIncrireServerSidePort) {
    operator fun invoke(utilisateur: Utilisateur) : Utilisateur {
        val emailRegex = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$".toRegex()
        if (!emailRegex.matches(utilisateur.email)) {
            throw IllegalArgumentException("Email invalide")
        }
        if (utilisateur.password.length < 8) {
            throw IllegalArgumentException("Mot de passe trop court")
        }
        if (utilisateur.username.length < 2) {
            throw IllegalArgumentException("Nom d'utilisateur trop court")
        }
        if (utilisateur.nom.length < 2) {
            throw IllegalArgumentException("Nom trop court")
        }
        if (utilisateur.prenom.length < 2) {
            throw IllegalArgumentException("Prenom trop court")
        }
        if (utilisateur.numeroDeTelephone.length < 10) {
            throw IllegalArgumentException("Numero de telephone trop court")
        }
        // regex mot de passe complexe
        val passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}\$".toRegex()
        if (!passwordRegex.matches(utilisateur.password)) {
            throw IllegalArgumentException("Mot de passe invalide")
        }
        // regex numero de telephone
        val phoneRegex = "^[0-9]{10}\$".toRegex()
        if (!phoneRegex.matches(utilisateur.numeroDeTelephone)) {
            throw IllegalArgumentException("Numero de telephone invalide")
        }
        return pourSinscrire(utilisateur)
    }
}