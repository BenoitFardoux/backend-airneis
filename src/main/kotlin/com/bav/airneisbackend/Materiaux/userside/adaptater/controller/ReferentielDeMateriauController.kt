package com.bav.airneisbackend.Materiaux.userside.adaptater.controller

import com.bav.airneisbackend.Materiaux.userside.adaptater.controller.documentation.ReferentielDeMateriauxControllerDocumentation
import com.bav.airneisbackend.Materiaux.userside.restressources.MateriauRestRessource
import org.springframework.hateoas.CollectionModel
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/airneis/materiau")
class ReferentielDeMateriauController : ReferentielDeMateriauxControllerDocumentation {

    @GetMapping(produces = [APPLICATION_JSON_VALUE])
    override fun recupererMateriaux(
        pageNumber: Int?,
        pageSize: Int?,
        critereDeRecherche: String?
    ): ResponseEntity<CollectionModel<MateriauRestRessource>> {

        TODO("Implementer recuperation des objets")
    }
}



