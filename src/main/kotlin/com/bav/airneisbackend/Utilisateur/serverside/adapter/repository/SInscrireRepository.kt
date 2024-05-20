package com.bav.airneisbackend.utilisateur.serverside.adapter.repository

import com.bav.airneisbackend.utilisateur.domain.port.serverside.PourSIncrireServerSidePort
import org.springframework.stereotype.Repository


@Repository
class SInscrireRepository : PourSIncrireServerSidePort {
    override fun invoke(email: String, motDePasse: String) {
        TODO("Not yet implemented")
    }
}