package com.bav.airneisbackend.Materiaux.fixture

import com.bav.airneisbackend.Materiaux.domain.model.Materiau
import com.bav.airneisbackend.Materiaux.serverside.dto.MateriauDocument
import com.bav.airneisbackend.Materiaux.userside.restressources.PourCreerMateriauRestRessource

class MateriauFixture {
    companion object {
        val materiauSansNom = Materiau(type = "bois", image = "chene.jpg", nom = "")
        val materiauSansId = Materiau(nom = "chene", type = "bois", image = "chene.jpg")
        val materiauDocument = MateriauDocument(id = "1223455", nom = "chene", type = "bois", image = "chene.jpg")
        val materiau = Materiau(id = "1223455", nom = "chene", type = "bois", image = "chene.jpg")
        val materiauPourRequetePost = PourCreerMateriauRestRessource(nom = "chene", type = "bois", image = "chene.jpg")

    }
}