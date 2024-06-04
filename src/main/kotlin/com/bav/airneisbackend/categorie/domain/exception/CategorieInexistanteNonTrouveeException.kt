package com.bav.airneisbackend.categorie.domain.exception

class CategorieInexistanteNonTrouveeException(val id : String) : CategorieException("La catégorie $id n'existe pas") {
}