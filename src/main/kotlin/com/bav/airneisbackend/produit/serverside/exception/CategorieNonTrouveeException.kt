package com.bav.airneisbackend.produit.serverside.exception

import com.bav.airneisbackend.produit.domain.exception.ProduitException

class CategorieNonTrouveeException(val id : String) : ProduitException("La catégorie $id n'existe pas")
