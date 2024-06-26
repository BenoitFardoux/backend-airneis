package com.bav.airneisbackend.utilisateur.userside.restressource

import com.bav.airneisbackend.utilisateur.domain.model.Adresse
import com.bav.airneisbackend.utilisateur.domain.model.MoyenDePaiement
import com.bav.airneisbackend.utilisateur.domain.model.Panier

data class UtilisateurRestRessource(
    val verifie : Boolean,
    val email: String,
    val nom : String,
    val prenom : String,
    val paiements : List<MoyenDePaiement>,
    val numeroDeTelephone : String,
    val adresse : List<Adresse>,
    val panierActuel : Panier,
    val commandes : List<Panier>
)
