package com.bav.airneisbackend.utilisateur.domain.usecase.adresse

import com.bav.airneisbackend.utilisateur.domain.model.Adresse
import com.bav.airneisbackend.utilisateur.domain.model.Utilisateur
import com.bav.airneisbackend.utilisateur.domain.port.serverside.adresse.ModifierAdressesServerSidePort
import org.springframework.stereotype.Component

@Component
class ModifierAdresses(private val pourModifierAdressesServerSidePort: ModifierAdressesServerSidePort) {
    operator fun invoke(addresses: List<Adresse>): Utilisateur {
        addresses.map { adresse ->
            adresse.estValide()
        }
        return pourModifierAdressesServerSidePort(addresses)

    }
}