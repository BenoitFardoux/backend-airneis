package com.bav.airneisbackend.utilisateur.domain.usecase.adresse

import com.bav.airneisbackend.utilisateur.domain.model.Adresse
import com.bav.airneisbackend.utilisateur.domain.port.serverside.adresse.PourAjouterUneAdresseServerSidePort
import org.springframework.stereotype.Service


@Service
class AjouterUneAdresse(
    val pourAjouterUneAdresseServerSidePort: PourAjouterUneAdresseServerSidePort
) {
    operator fun invoke(adresse: Adresse) = pourAjouterUneAdresseServerSidePort(adresse)
}
