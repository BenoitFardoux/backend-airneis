package com.bav.airneisbackend.produit.domain.exception

class ProduitInvalideException(override val description: String, val champs :List<String>) : ProduitException(description)