package com.bav.airneisbackend.produit.domain.port.serverside.produit

import com.bav.airneisbackend.produit.domain.model.Produit
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface RechercherProduit {
    operator fun invoke(pageRequest: Pageable, critereDeRecherche: String) : Page<Produit>
}