package com.bav.airneisbackend.produit.domain.usecase

import com.bav.airneisbackend.produit.domain.model.Produit
import com.bav.airneisbackend.produit.domain.port.serverside.produit.PourPersisterProduit
import org.springframework.stereotype.Component


@Component
class PersisterProduit(val pourPersisterProduit: PourPersisterProduit) {
    operator fun invoke(produit: Produit): Produit =
        pourPersisterProduit(produit)

}