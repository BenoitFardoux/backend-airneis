package com.bav.airneisbackend.utilisateur.domain.port.serverside

fun interface PourSIncrireServerSidePort {
    operator fun invoke(email: String, motDePasse: String)
}