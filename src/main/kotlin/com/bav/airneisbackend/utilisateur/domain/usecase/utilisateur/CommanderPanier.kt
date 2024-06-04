package com.bav.airneisbackend.utilisateur.domain.usecase.utilisateur

import com.bav.airneisbackend.utilisateur.domain.model.Adresse
import com.bav.airneisbackend.utilisateur.domain.model.MoyenDePaiement
import com.bav.airneisbackend.utilisateur.domain.model.Utilisateur
import com.bav.airneisbackend.utilisateur.domain.port.serverside.CommanderPanierServerSidePort
import com.bav.airneisbackend.utilisateur.serverside.exception.AdresseInvalideException
import org.springframework.stereotype.Component


@Component
class CommanderPanier(private val commanderPanierServerSidePort: CommanderPanierServerSidePort) {
     operator fun invoke(adresse: Adresse, moyenDePaiement: MoyenDePaiement) : Utilisateur {
        validateAdresse(adresse)
        return commanderPanierServerSidePort(adresse, moyenDePaiement)
    }

    private fun validateAdresse(adresse: Adresse) {
        val erreurs = mutableListOf<String>()

        fun String.checkAndAddError(fieldName: String) {
            if (this.isEmpty()) erreurs.add(fieldName)
        }

        adresse.apply {
            codePostal.checkAndAddError("code postal")
            numeroDeRue.checkAndAddError("numero de rue")
            informations.checkAndAddError("informations")
            ville.checkAndAddError("ville")
            pays.checkAndAddError("pays")
            telephone.checkAndAddError("telephone")
            prenom.checkAndAddError("prénom")
            nom.checkAndAddError("nom")
        }

        if (erreurs.isNotEmpty()) {
            throw AdresseInvalideException(erreurs)
        }
    }
}