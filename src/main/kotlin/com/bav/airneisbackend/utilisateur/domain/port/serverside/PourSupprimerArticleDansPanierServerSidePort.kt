package com.bav.airneisbackend.utilisateur.domain.port.serverside

import com.bav.airneisbackend.utilisateur.domain.model.produits.Produit

fun interface PourSupprimerArticleDansPanierServerSidePort {
    operator fun invoke(idArticle: String): Produit
}