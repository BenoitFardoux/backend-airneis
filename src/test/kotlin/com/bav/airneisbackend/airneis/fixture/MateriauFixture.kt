package com.bav.airneisbackend.airneis.fixture

import com.bav.airneisbackend.airneis.domain.model.Materiau
import com.bav.airneisbackend.airneis.serverside.dto.MateriauDocument
import com.bav.airneisbackend.airneis.serverside.dto.ReferentielDeMateriauDocument

class MateriauFixture {
    companion object {
        val materiauDocument = MateriauDocument("1","Bois")
        val referentielDeMateriauDocument = ReferentielDeMateriauDocument("1","Bois")
        val materiau = Materiau("1","Bois")
    }
}