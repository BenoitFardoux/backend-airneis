package com.bav.airneisbackend.airneis.serverside.adapter.repository

import com.bav.airneisbackend.airneis.domain.model.Materiau
import com.bav.airneisbackend.airneis.domain.port.serverside.PourRechercherMateriauParMotCleServerSidePort
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Repository


@Repository
class RecupererMateriauxParMotCleRepository : PourRechercherMateriauParMotCleServerSidePort{
    override fun recupererMateriauxParMotCle(pageRequest: PageRequest, critereDeRecherche: String): Page<Materiau> {
        TODO("Not yet implemented")
    }
}