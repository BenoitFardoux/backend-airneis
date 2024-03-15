package com.bav.airneisbackend.Materiaux.fixture

import com.bav.airneisbackend.Materiaux.domain.model.Materiau
import com.bav.airneisbackend.Materiaux.serverside.dto.MateriauDocument
import org.bson.types.ObjectId

class MateriauFixture {
    companion object {
        val materiauDocument = MateriauDocument(id = ObjectId(), nom = "chene", type = "bois", image = "chene.jpg")
        val materiau = Materiau(id = ObjectId(), nom = "chene", type = "bois", image = "chene.jpg")
    }
}