package com.bav.airneisbackend.produit.domain.port.serverside.produit

import com.bav.airneisbackend.produit.domain.model.Produit
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

fun interface PourRecupererProduitsServersidePort {
    operator fun invoke(pageable: Pageable) : Page<Produit>
}