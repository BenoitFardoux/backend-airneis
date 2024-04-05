package com.bav.airneisbackend.Materiaux.fixture

import com.bav.airneisbackend.Materiaux.domain.model.Materiau
import com.bav.airneisbackend.Materiaux.serverside.dto.MateriauDocument

class MateriauFixture {
    companion object {
        val materiauDocument = MateriauDocument(id = "", nom = "chene", type = "bois", image = "chene.jpg")
        val materiau = Materiau(id = "", nom = "chene", type = "bois", image = "chene.jpg")
    }
}