package com.bav.airneisbackend.categorie.domain.exception

class ProduitIntrouvableException(val id : String) : CategorieException("Le produit $id est introuvable")