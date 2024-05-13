package com.bav.airneisbackend.produit.domain.port.serverside.produit

import com.bav.airneisbackend.produit.domain.model.Produit

fun interface PourPersisterProduit {
    operator fun invoke(produit:Produit) : Produit
}