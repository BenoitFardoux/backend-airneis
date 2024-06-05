package com.bav.airneisbackend.utilisateur.domain.usecase.adresse

import com.bav.airneisbackend.utilisateur.domain.model.Adresse
import com.bav.airneisbackend.utilisateur.domain.model.Utilisateur
import com.bav.airneisbackend.utilisateur.domain.port.serverside.adresse.SupprimerAdresseServerSidePort
import org.springframework.stereotype.Service


@Service
class SupprimerUneAdresse(val supprimerAdresseServerSidePort: SupprimerAdresseServerSidePort) {
    operator fun invoke(adresse: Adresse) : Utilisateur = supprimerAdresseServerSidePort(adresse)
}