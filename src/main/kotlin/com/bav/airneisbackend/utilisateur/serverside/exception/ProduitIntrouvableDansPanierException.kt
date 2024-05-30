package com.bav.airneisbackend.utilisateur.serverside.exception

class ProduitIntrouvableDansPanierException(val id : String) : UtilisateurException("L'article $id n'est pas dans le panier") {
}