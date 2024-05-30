package com.bav.airneisbackend.utilisateur.domain.usecase

import com.bav.airneisbackend.utilisateur.domain.model.produits.Produit
import com.bav.airneisbackend.utilisateur.domain.port.serverside.PourSupprimerArticleDansPanierServerSidePort
import org.springframework.stereotype.Component


@Component
class SupprimerArticleDansPanier(
    val pourSupprimerArticleDansPanierServerSidePort: PourSupprimerArticleDansPanierServerSidePort
) {
    operator fun invoke(idArticle: String) : Produit = pourSupprimerArticleDansPanierServerSidePort.invoke(idArticle)
}
