package com.bav.airneisbackend.categorie.domain.port.serverside.categorie

import com.bav.airneisbackend.categorie.domain.model.Categorie

interface PourRecupererUneCategorie {
  operator fun invoke(id: String): Categorie
}