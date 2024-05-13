package com.bav.airneisbackend.produit.domain.usecase

import com.bav.airneisbackend.produit.domain.port.serverside.produit.PourRecupererProduitParId
import org.springframework.stereotype.Component


@Component
class RecupererUnProduit(
    val pourRecupererProduitParId: PourRecupererProduitParId
) {
    operator fun invoke(id: String) = pourRecupererProduitParId(id)
}