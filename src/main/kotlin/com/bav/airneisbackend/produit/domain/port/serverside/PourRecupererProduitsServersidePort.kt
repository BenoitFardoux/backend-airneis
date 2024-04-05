package com.bav.airneisbackend.produit.domain.port.serverside

import com.bav.airneisbackend.produit.domain.model.Produit
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface PourRecupererProduitsServersidePort {
    fun recupererProduits(pageable: Pageable) : Page<Produit>
}