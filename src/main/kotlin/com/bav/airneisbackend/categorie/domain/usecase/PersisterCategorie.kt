package com.bav.airneisbackend.categorie.domain.usecase

import com.bav.airneisbackend.categorie.domain.port.serverside.categorie.PourPersisterCategorie
import org.springframework.stereotype.Component


@Component
class PersisterCategorie(val pourPersisterCategorie: PourPersisterCategorie) {
}