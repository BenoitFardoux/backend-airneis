package com.bav.airneisbackend.Produit.domain.exception

abstract class ProduitException(
    open val description: String
) : RuntimeException() {
    override val message: String
        get() = description
}