package com.bav.airneisbackend.Materiaux.serverside.dto

import org.springframework.data.mongodb.core.mapping.Document


@Document("referentielDeMateriau")
data class ReferentielDeMateriauDocument (
    val id : String,
    val name : String
)