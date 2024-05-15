package com.bav.airneisbackend.categorie.domain.exception

abstract class CategorieException(open val description: String) : RuntimeException() {
    override val message: String
        get() = description
}