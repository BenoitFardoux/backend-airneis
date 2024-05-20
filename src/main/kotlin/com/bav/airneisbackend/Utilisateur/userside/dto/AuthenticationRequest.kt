package com.bav.airneisbackend.utilisateur.userside.dto

data class AuthenticationRequest(
    val username: String,
    val password: String
)
