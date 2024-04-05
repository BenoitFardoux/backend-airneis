package com.bav.airneisbackend.produit.domain.usecase

import com.bav.airneisbackend.produit.domain.model.Produit
import com.bav.airneisbackend.produit.serverside.adapter.repository.PourRecupererProduitsRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Component

@Component
class RecupererProduits(val pourRecupererProduitsRepository: PourRecupererProduitsRepository) {
    operator fun invoke(pageable: Pageable): Page<Produit> = pourRecupererProduitsRepository.recupererProduits(pageable)
}