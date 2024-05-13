package com.bav.airneisbackend.produit.domain.port.serverside.categorie

import com.bav.airneisbackend.produit.domain.model.Categorie

interface PourRecupererCategoriesServerSidePort {
    fun recupererCategories() : List<Categorie>

    fun recupererCategorieParId(id: String) : Categorie
}