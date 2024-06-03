package com.bav.airneisbackend.utilisateur.userside.restressource

import com.bav.airneisbackend.utilisateur.domain.model.Adresse
import com.bav.airneisbackend.utilisateur.domain.model.MoyenDePaiement

data class FacturationRestRessource(
    val adresse : Adresse,
    val moyenDePaiement: MoyenDePaiement
)
