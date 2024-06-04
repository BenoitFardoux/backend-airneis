package com.bav.airneisbackend.utilisateur.domain.usecase.utilisateur

import com.bav.airneisbackend.utilisateur.domain.model.Utilisateur
import com.bav.airneisbackend.utilisateur.domain.port.serverside.InscriptionUtilisateurServerSidePort
import org.springframework.stereotype.Component


@Component
class InscriptionUtilisateur (
    val inscriptionUtilisateurServerSidePort: InscriptionUtilisateurServerSidePort
){
    operator fun invoke(utilisateur: Utilisateur) : Utilisateur = inscriptionUtilisateurServerSidePort(utilisateur)
}