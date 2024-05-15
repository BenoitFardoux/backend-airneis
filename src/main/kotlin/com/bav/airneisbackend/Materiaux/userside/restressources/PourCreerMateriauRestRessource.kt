package com.bav.airneisbackend.Materiaux.userside.restressources

import com.bav.airneisbackend.Materiaux.domain.model.Image
import com.bav.airneisbackend.Materiaux.domain.model.Materiau

data class PourCreerMateriauRestRessource(
    val nom: String,
    val image: Image
)