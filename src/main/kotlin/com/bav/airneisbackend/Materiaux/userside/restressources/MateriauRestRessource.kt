package com.bav.airneisbackend.Materiaux.userside.restressources

import com.bav.airneisbackend.Materiaux.domain.model.Image
import com.bav.airneisbackend.Materiaux.domain.model.Materiau

data class MateriauRestRessource (
    val id : String?,
    val nom : String?,
    val type :String?,
    val image : Image?
)
