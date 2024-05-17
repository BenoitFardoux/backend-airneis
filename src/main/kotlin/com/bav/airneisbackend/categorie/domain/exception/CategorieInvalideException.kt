package com.bav.airneisbackend.categorie.domain.exception

class CategorieInvalideException(override val description: String, val champs : List<String>) : CategorieException(description)
