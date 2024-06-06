package com.bav.airneisbackend.categorie.domain.port.serverside.categorie

import com.bav.airneisbackend.categorie.domain.model.Categorie

fun interface PourRecupererCategories {
    operator fun invoke(): List<Categorie>
}