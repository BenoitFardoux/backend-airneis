package com.bav.airneisbackend.utilisateur.domain.usecase.utilisateur

import com.bav.airneisbackend.utilisateur.domain.model.Adresse
import com.bav.airneisbackend.utilisateur.domain.model.MoyenDePaiement
import com.bav.airneisbackend.utilisateur.domain.model.Utilisateur
import com.bav.airneisbackend.utilisateur.domain.port.serverside.CommanderPanierServerSidePort
import org.springframework.stereotype.Component


@Component
class CommanderPanier(private val commanderPanierServerSidePort: CommanderPanierServerSidePort) {
     operator fun invoke(adresse: Adresse, moyenDePaiement: MoyenDePaiement) : Utilisateur {
            adresse.estValide()
        return commanderPanierServerSidePort(adresse, moyenDePaiement)
    }
}