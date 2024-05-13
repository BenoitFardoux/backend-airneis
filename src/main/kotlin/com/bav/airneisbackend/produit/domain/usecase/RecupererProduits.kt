package com.bav.airneisbackend.produit.domain.usecase

import com.bav.airneisbackend.produit.domain.model.Produit
import com.bav.airneisbackend.produit.domain.port.serverside.produit.PourRecupererProduitsServersidePort
import com.bav.airneisbackend.produit.domain.port.serverside.produit.RechercherProduit
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Component

@Component
class RecupererProduits(
    val pourRecupererProduitsServersidePort: PourRecupererProduitsServersidePort,
    val rechercherProduit: RechercherProduit
) {
    operator fun invoke(pageable: Pageable, critere: String?): Page<Produit> =
        critere?.let { rechercherProduit(pageable, it) } ?: pourRecupererProduitsServersidePort(pageable)
}