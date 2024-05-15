package com.bav.airneisbackend.Materiaux.userside.restressources

import com.bav.airneisbackend.Materiaux.domain.model.Image

data class PourCreerMateriauRestRessource(
    val nom: String,
    val type:String,
    val image: Image
)