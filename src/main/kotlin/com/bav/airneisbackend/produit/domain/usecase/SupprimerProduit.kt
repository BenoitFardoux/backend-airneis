package com.bav.airneisbackend.produit.domain.usecase

import com.bav.airneisbackend.produit.domain.port.serverside.produit.PourSupprimerProduit
import org.springframework.stereotype.Component


@Component
class SupprimerProduit (val pourSupprimerProduit: PourSupprimerProduit){
    operator fun invoke(id: String) = pourSupprimerProduit(id)
}