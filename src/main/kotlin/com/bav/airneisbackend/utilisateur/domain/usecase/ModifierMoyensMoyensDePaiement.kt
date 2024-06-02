package com.bav.airneisbackend.utilisateur.domain.usecase

import com.bav.airneisbackend.utilisateur.domain.model.MoyenDePaiement
import com.bav.airneisbackend.utilisateur.domain.model.Utilisateur
import com.bav.airneisbackend.utilisateur.domain.port.serverside.PourModifierMoyensDePaiementServerSidePort
import com.bav.airneisbackend.utilisateur.serverside.exception.MoyenDePaiementsInvalideException
import org.springframework.stereotype.Component


@Component
class ModifierMoyensMoyensDePaiement(val pourModifierMoyensDePaiementServerSidePort: PourModifierMoyensDePaiementServerSidePort) {
    operator fun invoke(paiements : List<MoyenDePaiement>) : Utilisateur{
        paiements.forEach{
            if (it.numeroCarte.length != 16) {
                throw MoyenDePaiementsInvalideException("Le numéro de carte doit contenir 16 chiffres")
            }
            if (it.dateExpiration.length != 5) {
                throw MoyenDePaiementsInvalideException("La date d'expiration doit être au format MM/AA")
            }
            if (it.codeSecurite.length != 3) {
                throw MoyenDePaiementsInvalideException("Le code de sécurité doit contenir 3 chiffres")
            }
            if (it.nomCarte.isEmpty()) {
                throw MoyenDePaiementsInvalideException("Le nom du titulaire ne peut pas être vide")
            }
        }
        return pourModifierMoyensDePaiementServerSidePort(paiements)
    }

}