package com.bav.airneisbackend.categorie.domain.exception

class CategorieInconnueException (val categorieId: String):
    CategorieException("")
{
  override val message: String
    get() = "Le brouillon de contrat '$categorieId' n'existe pas"
}