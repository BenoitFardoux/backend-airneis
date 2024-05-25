package com.bav.airneisbackend.utilisateur.userside.restressource

data class LoginResponse(
    val token: String,

    val expiresIn: Long
)
