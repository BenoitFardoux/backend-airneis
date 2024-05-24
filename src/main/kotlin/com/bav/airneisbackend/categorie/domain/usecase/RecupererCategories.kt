package com.bav.airneisbackend.categorie.domain.usecase

import com.bav.airneisbackend.categorie.domain.port.serverside.categorie.PourRecupererCategories
import org.springframework.stereotype.Component


@Component
class RecupererCategories (
    val pourRecupererCategories: PourRecupererCategories,
) {
  operator fun invoke(pageable: Pageable): Page<Categorie> =
      pourRecupererCategories(pageable)
}