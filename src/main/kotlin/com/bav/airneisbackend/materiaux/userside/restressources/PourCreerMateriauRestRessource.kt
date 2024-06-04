package com.bav.airneisbackend.materiaux.userside.restressources

import com.bav.airneisbackend.materiaux.domain.model.Image

data class PourCreerMateriauRestRessource(
    val nom: String,
    val type:String,
    val image: Image
)