package com.bav.airneisbackend.utilisateur.domain.port.serverside

fun interface PourSeConnecterServerSidePort {
    operator fun invoke(email: String, motDePasse: String) : String
}