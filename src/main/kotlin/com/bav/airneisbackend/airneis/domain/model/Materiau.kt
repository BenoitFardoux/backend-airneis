package com.bav.airneisbackend.airneis.domain.model

data class Materiau(
    val id : String,
    val nom : String,
    val images : List<String>,
    val typeMateriau: String
)
