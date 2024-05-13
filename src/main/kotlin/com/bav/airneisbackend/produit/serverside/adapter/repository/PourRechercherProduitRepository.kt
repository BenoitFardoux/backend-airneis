package com.bav.airneisbackend.produit.serverside.adapter.repository

import com.bav.airneisbackend.produit.domain.model.Produit
import com.bav.airneisbackend.produit.domain.port.serverside.produit.RechercherProduit
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Repository


@Repository
class PourRechercherProduitRepository : RechercherProduit {

    override fun invoke(pageRequest: Pageable, critereDeRecherche: String): Page<Produit> {
        TODO("Not yet implemented")
    }
}