package com.bav.airneisbackend.categorie.domain.exception

class CategorieNonTrouveeException(id: String) : CategorieException("la categorie $id n'existe pas") {
}