package com.bav.airneisbackend.airneis.fixture

import com.bav.airneisbackend.airneis.domain.model.Materiau
import com.bav.airneisbackend.airneis.serverside.dto.MateriauDocument
import com.bav.airneisbackend.airneis.serverside.dto.ReferentielDeMateriauDocument

class MateriauFixture {
    companion object {
        val materiauDocument = MateriauDocument(materiauId = "1", name = "chene")
        val referentielDeMateriauDocument = ReferentielDeMateriauDocument("1","chene")
        val materiau = Materiau("1","chene")
    }
}