package com.bav.airneisbackend.produit.fixture

import com.bav.airneisbackend.materiaux.domain.model.Image
import com.bav.airneisbackend.materiaux.serverside.dto.MateriauDocument
import com.bav.airneisbackend.produit.domain.model.Materiau
import com.bav.airneisbackend.produit.userside.restressources.materiau.MateriauPourCreerProduitRestRessource


class MateriauFixture {
    companion object {
        val materiau = Materiau(id = "1223455", nom = "chene")
        val materiauPourCreerProduitRestRessource = MateriauPourCreerProduitRestRessource(materiau.id)
        val materiauDocument = MateriauDocument(
            id = "1223455",
            nom = "chene",
            type = "bois",
            image = Image(
                url = "chene.jpg",
                description = "chene"
            )
        )
    }
}