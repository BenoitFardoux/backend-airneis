package com.bav.airneisbackend.materiaux.fixture

import com.bav.airneisbackend.materiaux.domain.model.Image
import com.bav.airneisbackend.materiaux.domain.model.Materiau
import com.bav.airneisbackend.materiaux.serverside.dto.MateriauDocument
import com.bav.airneisbackend.materiaux.userside.restressources.PourCreerMateriauRestRessource

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