package com.bav.airneisbackend.Produit.domain.port.serverside.produit

import com.bav.airneisbackend.Produit.domain.model.Produit

fun interface PourPersisterProduit {
    operator fun invoke(produit:Produit) : Produit
}