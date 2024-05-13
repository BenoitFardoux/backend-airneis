package com.bav.airneisbackend.Produit.domain.usecase

import com.bav.airneisbackend.Produit.domain.port.serverside.produit.PourRecupererProduitParId
import com.bav.airneisbackend.Produit.serverside.adapter.repository.PourRecupererUnProduitRepository
import org.springframework.stereotype.Component


@Component
class RecupererUnProduit(
    val pourRecupererProduitParId: PourRecupererProduitParId
) {
    operator fun invoke(id: String) = pourRecupererProduitParId(id)
}