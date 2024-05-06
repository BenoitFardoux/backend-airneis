package com.bav.airneisbackend.Produit.domain.port.serverside.produit

import com.bav.airneisbackend.Produit.domain.model.Produit
import org.springframework.data.domain.Pageable

fun interface PourRecupererProduitParId {
    operator fun invoke(id: String): Produit
}