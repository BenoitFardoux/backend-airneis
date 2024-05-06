package com.bav.airneisbackend.Materiaux.userside.adaptater.controller

import com.bav.airneisbackend.Materiaux.domain.exception.MateriauNonTrouveException
import com.bav.airneisbackend.Materiaux.domain.usecase.RecupererMateriaux
import com.bav.airneisbackend.Materiaux.userside.adaptater.controller.documentation.ReferentielDeMateriauxControllerDocumentation
import com.bav.airneisbackend.Materiaux.userside.mapper.MateriauMapper
import com.bav.airneisbackend.Materiaux.userside.restressources.MateriauRestRessource
import org.springframework.data.domain.PageRequest
import org.springframework.hateoas.CollectionModel
import org.springframework.hateoas.PagedModel
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/airneis/materiau")
class ReferentielDeMateriauController(
    private val recupererMateriaux: RecupererMateriaux
) : ReferentielDeMateriauxControllerDocumentation {

    @GetMapping(produces = [APPLICATION_JSON_VALUE])
    override fun recupererMateriaux(
        @RequestParam("pageNumber", defaultValue = "0") pageNumber: Int,
        @RequestParam("pageSize", defaultValue = "10") pageSize: Int,
        critereDeRecherche: String?
    ): ResponseEntity<CollectionModel<MateriauRestRessource>> {
        try {
            val pageable = PageRequest.of(pageNumber, pageSize)
            val materiaux = recupererMateriaux(pageable, critereDeRecherche)

            val materiauxRestRessource = MateriauMapper.mapMateriauPageToMateriauRestRessource(materiaux)
            val pagedModel = PagedModel.of(materiauxRestRessource)

            pagedModel.add(
                WebMvcLinkBuilder.linkTo(
                    WebMvcLinkBuilder.methodOn(ReferentielDeMateriauController::class.java)
                        .recupererMateriaux(pageNumber, pageSize, critereDeRecherche)
                ).withSelfRel()
            )

            return ResponseEntity.ok(pagedModel)
        } catch (e: Exception) {
            return ResponseEntity.notFound().build()
        }
    }
}



