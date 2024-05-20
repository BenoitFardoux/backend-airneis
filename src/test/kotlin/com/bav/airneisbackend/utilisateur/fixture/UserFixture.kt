package com.bav.airneisbackend.utilisateur.fixture

import com.bav.airneisbackend.utilisateur.domain.model.Panier
import com.bav.airneisbackend.utilisateur.domain.model.Utilisateur

object UserFixture {
    val panierVide = Panier(
        id = "",
        produits = emptyList()
    )
    val utilisateurValide = Utilisateur(
        username = "test",
        password = "test",
        verifie = true,
        email = "mail@gmail.com",
        nom = "test",
        prenom = "test",
        panierActuel = panierVide,
        numeroDeTelephone = "1234567890"
    )
}