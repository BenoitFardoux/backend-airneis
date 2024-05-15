package com.bav.airneisbackend.Materiaux.fixture

import com.bav.airneisbackend.Materiaux.domain.model.Image
import com.bav.airneisbackend.Materiaux.domain.model.Materiau
import com.bav.airneisbackend.Materiaux.serverside.dto.MateriauDocument
import com.bav.airneisbackend.Materiaux.userside.restressources.PourCreerMateriauRestRessource

class MateriauFixture {
    companion object {
        private val image = Image(url = "chene.jpg", description = "chene")
        val materiauSansNom = Materiau(type = "bois", image=image, nom = "")
        val materiauSansId = Materiau(nom = "chene", type = "bois", image=image)
        val materiauDocument = MateriauDocument(id = "1223455", nom = "chene", type = "bois", image=image)
        val materiau = Materiau(id = "1223455", nom = "chene", type = "bois", image=image)
        val materiauPourRequetePost = PourCreerMateriauRestRessource(nom = "chene", type = "bois", image=image)

    }
}