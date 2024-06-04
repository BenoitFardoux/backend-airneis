package com.bav.airneisbackend.utilisateur.domain.usecase

import com.bav.airneisbackend.utilisateur.domain.model.MoyenDePaiement
import com.bav.airneisbackend.utilisateur.domain.model.Utilisateur
import com.bav.airneisbackend.utilisateur.domain.port.serverside.PourModifierMoyensDePaiementServerSidePort
import com.bav.airneisbackend.utilisateur.serverside.exception.MoyenDePaiementsInvalideException
import org.springframework.stereotype.Component


@Component
class ModifierMoyensMoyensDePaiement(val pourModifierMoyensDePaiementServerSidePort: PourModifierMoyensDePaiementServerSidePort) {
    operator fun invoke(paiements : List<MoyenDePaiement>) : Utilisateur{
        paiements.forEach{ item ->
            if (item.numeroCarte.isEmpty() || item.dateExpiration.isEmpty() || item.codeSecurite.isEmpty() || item.nomCarte.isEmpty()) {
                throw MoyenDePaiementsInvalideException("Tous les champs sont obligatoires")
            }
            // verifie si le moyen de paiement est déjà enregistré
            if (paiements.groupBy { it.numeroCarte }.values.any { it.size > 1 }) {
                throw MoyenDePaiementsInvalideException("Ce moyen de paiement est déjà enregistré")
            }
            if (item.numeroCarte.length != 16) {
                throw MoyenDePaiementsInvalideException("Le numéro de carte doit contenir 16 chiffres")
            }
            if (item.dateExpiration.length != 5) {
                throw MoyenDePaiementsInvalideException("La date d'expiration doit être au format MM/AA")
            }
            if (item.codeSecurite.length != 3) {
                throw MoyenDePaiementsInvalideException("Le code de sécurité doit contenir 3 chiffres")
            }
            if (item.nomCarte.isEmpty()) {
                throw MoyenDePaiementsInvalideException("Le nom du titulaire ne peut pas être vide")
            }
        }
        return pourModifierMoyensDePaiementServerSidePort(paiements)
    }

}