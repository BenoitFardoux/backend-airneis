package com.bav.airneisbackend.Produit.domain.port.serverside.categorie

import com.bav.airneisbackend.Produit.domain.model.Categorie

interface PourRecupererCategoriesServerSidePort {
    fun recupererCategories() : List<Categorie>

    fun recupererCategorieParId(id: String) : Categorie
}