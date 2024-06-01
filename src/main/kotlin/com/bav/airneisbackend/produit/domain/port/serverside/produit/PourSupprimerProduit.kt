package com.bav.airneisbackend.produit.domain.port.serverside.produit

import com.bav.airneisbackend.produit.domain.model.Produit

fun interface PourSupprimerProduit {
    operator fun invoke(id: String): Produit
}