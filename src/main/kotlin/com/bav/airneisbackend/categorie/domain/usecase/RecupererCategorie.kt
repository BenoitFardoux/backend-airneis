package com.bav.airneisbackend.categorie.domain.usecase

import com.bav.airneisbackend.categorie.domain.model.Categorie
import com.bav.airneisbackend.categorie.domain.port.serverside.categorie.PourRecupererUneCategorie
import org.springframework.stereotype.Component


@Component
class RecupererCategorie(val pourRecupererUneCategorie: PourRecupererUneCategorie) {
  operator fun invoke(id: String): Categorie{
    return pourRecupererUneCategorie(id)
  }
}