package com.bav.airneisbackend.utilisateur.userside.mapper

import com.bav.airneisbackend.utilisateur.domain.model.MoyenDePaiement
import com.bav.airneisbackend.utilisateur.userside.restressource.MoyenDePaiementUtilisateursRestRessource
import com.bav.airneisbackend.utilisateur.userside.restressource.MoyensDePaiementUtilisateursRestRessource

object PaiementsMapper {
    fun MoyenDePaiementUtilisateursRestRessource.toPaiement() = MoyenDePaiement(
        numeroCarte = numeroCarte,
        dateExpiration = dateExpiration,
        codeSecurite = codeSecurite,
        nomCarte = nomCarte,
        estParDefaut = estParDefaut
    )

    fun MoyensDePaiementUtilisateursRestRessource.toPaiements() = cartes.map { it.toPaiement() }
}