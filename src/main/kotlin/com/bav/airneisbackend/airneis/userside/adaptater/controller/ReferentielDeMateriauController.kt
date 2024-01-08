package com.bav.airneisbackend.airneis.userside.adaptater.controller

import com.bav.airneisbackend.airneis.domain.model.Materiau
import com.bav.airneisbackend.airneis.userside.adaptater.controller.documentation.ReferentielDeMateriauxControllerDocumentation
import com.bav.airneisbackend.airneis.userside.restressources.MateriauRestRessource
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.hateoas.CollectionModel
import org.springframework.http.ResponseEntity

class ReferentielDeMateriauController : ReferentielDeMateriauxControllerDocumentation {
    override fun recupererMateriaux(
        pageNumber: Int,
        pageSize: Int,
        critereDeRecherche: String
    ): ResponseEntity<CollectionModel<MateriauRestRessource>> {

        val pageable = PageRequest.of(pageNumber, pageSize)
        val materiauPage: Page<Materiau> = recupererMateriaux(pageable, critereDeRecherche)
        val centresDeFormationRestRessource =
            ReferentielDeCentreDeCentreDeFormationMapper.mapCentreDeFormationPageToCentreDeFormationRestRessource(
                centresDeFormationPage
            )
        val pagedModel = PagedModel.of(centresDeFormationRestRessource)
        pagedModel.add(
            WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(ReferentielDeCentreDeFormationController::class.java)
                    .recupererCentresDeFormation(pageNumber, pageSize, critereDeRecherche)
            ).withSelfRel()
        )
        return ResponseEntity.ok(pagedModel)
    }
}