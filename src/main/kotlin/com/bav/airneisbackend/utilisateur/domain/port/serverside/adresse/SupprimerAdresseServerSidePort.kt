package com.bav.airneisbackend.utilisateur.domain.port.serverside.adresse

import com.bav.airneisbackend.utilisateur.domain.model.Adresse
import com.bav.airneisbackend.utilisateur.domain.model.Utilisateur

fun interface SupprimerAdresseServerSidePort {
    operator fun invoke(adresse : Adresse) : Utilisateur
}