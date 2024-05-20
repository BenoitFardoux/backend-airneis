package com.bav.airneisbackend.utilisateur.userside.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank

data class RequeteInscription(
    val username : String,
    val nom: String,
    val prenom: String,
    @field:Email(message = "Email should be valid")
    @field:NotBlank(message = "Email is mandatory")
    val email: String,
    val motDePasse: String,
    val numeroDeTelephone : String
)
