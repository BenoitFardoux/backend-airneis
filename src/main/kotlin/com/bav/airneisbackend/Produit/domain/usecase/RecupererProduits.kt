package com.bav.airneisbackend.Produit.domain.usecase

import com.bav.airneisbackend.Produit.domain.model.Produit
import com.bav.airneisbackend.Produit.serverside.adapter.repository.PourRecupererProduitsRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Component

@Component
class RecupererProduits(val pourRecupererProduitsRepository: PourRecupererProduitsRepository) {
    operator fun invoke(pageable: Pageable): Page<Produit> = pourRecupererProduitsRepository(pageable)
}