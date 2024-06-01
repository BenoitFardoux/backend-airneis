package com.bav.airneisbackend.produit.serverside.exception

import com.bav.airneisbackend.produit.domain.exception.ProduitException

class ProduitIntrouvableException(override val description : String) : ProduitException(description) {
}