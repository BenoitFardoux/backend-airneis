package com.bav.airneisbackend.utilisateur.serverside.exception

class ProduitsIntrouvableException (ids : List<String>): UtilisateurException("Les produits ${ids.joinToString()}") {
}