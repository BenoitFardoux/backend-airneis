package com.bav.airneisbackend.categorie.domain.port.serverside.categorie

import com.bav.airneisbackend.categorie.domain.model.Categorie

fun interface PourPersisterCategorie {
    operator fun invoke(categorie: Categorie) : Categorie
}