package com.bav.airneisbackend.Materiaux.userside.adaptater.controller

import com.bav.airneisbackend.Materiaux.domain.exception.MateriauNonTrouveException
import com.bav.airneisbackend.Materiaux.domain.model.Materiau
import com.bav.airneisbackend.Materiaux.domain.usecase.PersisterUnMateriau
import com.bav.airneisbackend.Materiaux.domain.usecase.RecupererMateriaux
import com.bav.airneisbackend.Materiaux.domain.usecase.RecupererUnMateriau
import com.bav.airneisbackend.Materiaux.userside.adaptater.controller.documentation.ReferentielDeMateriauxControllerDocumentation
import com.bav.airneisbackend.Materiaux.userside.mapper.MateriauMapper
import com.bav.airneisbackend.Materiaux.userside.restressources.MateriauRestRessource
import com.bav.airneisbackend.Materiaux.userside.restressources.PersitanceBadRequest
import com.bav.airneisbackend.Materiaux.userside.restressources.PourCreerMateriauRestRessource
import org.springframework.data.domain.PageRequest
import org.springframework.hateoas.CollectionModel
import org.springframework.hateoas.PagedModel
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.net.URI


@RestController
@RequestMapping("/airneis/materiau")
class ReferentielDeMateriauController(
    private val recupererMateriaux: RecupererMateriaux,
    private val recupererMateriauxParId: RecupererUnMateriau,
    private val persisterUnMateriau: PersisterUnMateriau
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
        } catch (e: MateriauNonTrouveException) {
            return ResponseEntity.notFound().build()
        }
    }


    @GetMapping("/{id}", produces = [APPLICATION_JSON_VALUE])
    override fun recupererMateriauParId( @PathVariable id: String): ResponseEntity<MateriauRestRessource> {
        return try {
            val materiau : Materiau = recupererMateriauxParId(id)

            val materiauRestRessource = MateriauMapper.materiauToMateriauRestRessource(materiau)

            ResponseEntity.ok(materiauRestRessource)
        } catch (e: MateriauNonTrouveException) {
            ResponseEntity.notFound().build()
        }
    }

    @PostMapping
    override fun persisteMateriau(@RequestBody materiau: PourCreerMateriauRestRessource): (ResponseEntity<Any>){
        val champsManquants = ArrayList<String>()

        if (materiau.nom.isNullOrBlank()) {
            champsManquants.add("nom")
        }
        if (materiau.type.isNullOrBlank()) {
            champsManquants.add("type")
        }
        if (materiau.image.isNullOrBlank()) {
            champsManquants.add("image")
        }


        if (champsManquants.isNotEmpty()) {
            val message = "Des informations sont manquantes : " + champsManquants.joinToString(", ")
            return ResponseEntity.badRequest().body(PersitanceBadRequest(message))
        }

        val materiauRecuperer = MateriauMapper.pourCreerMateriauRestRessourceToMateriau(materiau)

        val persisterMateriau = persisterUnMateriau(materiauRecuperer)

        val uriMateriau = URI("/airneis/materiau/${persisterMateriau.id}")
        val materiauRestRessource = MateriauMapper.materiauToMateriauRestRessource(persisterMateriau)
        return ResponseEntity.created(uriMateriau).body(materiauRestRessource)
    }
}



