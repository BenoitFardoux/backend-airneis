package com.bav.airneisbackend.Produit.serverside.adapter.repository

import com.bav.airneisbackend.Produit.domain.model.Produit
import com.bav.airneisbackend.Produit.domain.port.serverside.produit.RechercherProduit
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Repository


@Repository
class PourRechercherProduitRepository : RechercherProduit {

    override fun invoke(pageRequest: Pageable, critereDeRecherche: String): Page<Produit> {
        TODO("Not yet implemented")
    }
}