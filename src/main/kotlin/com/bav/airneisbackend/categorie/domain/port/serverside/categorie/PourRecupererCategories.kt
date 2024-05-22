package com.bav.airneisbackend.categorie.domain.port.serverside.categorie

import com.bav.airneisbackend.categorie.domain.model.Categorie
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

fun interface PourRecupererCategories {
  operator fun invoke(pageable: Pageable): Page<Categorie>
}