package com.bav.airneisbackend.utilisateur.serverside.exception

abstract class UtilisateurException(
    open val description: String
) : RuntimeException() {
    override val message: String
        get() = description
}