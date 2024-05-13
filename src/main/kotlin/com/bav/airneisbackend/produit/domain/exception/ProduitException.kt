package com.bav.airneisbackend.produit.domain.exception

abstract class ProduitException(
    open val description: String
) : RuntimeException() {
    override val message: String
        get() = description
}