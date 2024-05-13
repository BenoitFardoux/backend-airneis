package com.bav.airneisbackend.Produit.domain.port.serverside.produit

import com.bav.airneisbackend.Produit.domain.model.Produit
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface RechercherProduit {
    operator fun invoke(pageRequest: Pageable, critereDeRecherche: String) : Page<Produit>
}