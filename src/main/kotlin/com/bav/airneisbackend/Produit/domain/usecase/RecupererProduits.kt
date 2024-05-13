package com.bav.airneisbackend.Produit.domain.usecase

import com.bav.airneisbackend.Produit.domain.model.Produit
import com.bav.airneisbackend.Produit.domain.port.serverside.produit.PourRecupererProduitsServersidePort
import com.bav.airneisbackend.Produit.domain.port.serverside.produit.RechercherProduit
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