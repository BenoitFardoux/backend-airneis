package com.bav.airneisbackend.materiaux.userside.adaptater.controller

import com.bav.airneisbackend.materiaux.domain.model.Materiau
import com.bav.airneisbackend.materiaux.domain.usecase.PersisterUnMateriau
import com.bav.airneisbackend.materiaux.domain.usecase.RecupererMateriaux
import com.bav.airneisbackend.materiaux.domain.usecase.RecupererUnMateriau
import com.bav.airneisbackend.materiaux.userside.adaptater.controller.documentation.ReferentielDeMateriauxControllerDocumentation
import com.bav.airneisbackend.materiaux.userside.mapper.MateriauMapper
import com.bav.airneisbackend.materiaux.userside.restressources.MateriauRestRessource
import com.bav.airneisbackend.materiaux.userside.restressources.PersitanceBadRequest
import com.bav.airneisbackend.materiaux.userside.restressources.PourCreerMateriauRestRessource
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.data.domain.PageRequest
import org.springframework.hateoas.CollectionModel
import org.springframework.hateoas.PagedModel
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
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
    private val persisterUnMateriau: PersisterUnMateriau,
) : ReferentielDeMateriauxControllerDocumentation {

    @GetMapping(produces = [APPLICATION_JSON_VALUE])
    override fun recupererMateriaux(
        @RequestParam("pageNumber", defaultValue = "0") pageNumber: Int,
        @RequestParam("pageSize", defaultValue = "10") pageSize: Int,
        critereDeRecherche: String?
    ): ResponseEntity<CollectionModel<MateriauRestRessource>> {
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
    }


    @GetMapping("/{id}", produces = [APPLICATION_JSON_VALUE])
    override fun recupererMateriauParId( @PathVariable id: String): ResponseEntity<MateriauRestRessource> {

            val materiau : Materiau = recupererMateriauxParId(id)

            val materiauRestRessource = MateriauMapper.materiauToMateriauRestRessource(materiau)

        return    ResponseEntity.ok(materiauRestRessource)
    }

    @PostMapping
    @SecurityRequirement(name = "Bearer Authentication")

    override fun persisteMateriau(@RequestBody materiau: PourCreerMateriauRestRessource): (ResponseEntity<Any>){
        val champsManquants = ArrayList<String>()

        if (materiau.nom.isBlank()) {
            champsManquants.add("nom")
        }
        if (materiau.type.isBlank()) {
            champsManquants.add("type")
        }
           if (materiau.image.url.isBlank()) {
                champsManquants.add("image.url")
            }
            if (materiau.image.description.isBlank()) {
                champsManquants.add("image.description")
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


    @SecurityRequirement(name = "Bearer Authentication")
    @DeleteMapping("/{id}")
    override fun supprimeMateriau(@PathVariable id: String): ResponseEntity<MateriauRestRessource> {
        throw NotImplementedError("Not yet implemented")
    }


}



