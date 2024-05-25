package com.bav.airneisbackend.categorie.userside.adaptater.controller

import com.bav.airneisbackend.categorie.domain.usecase.PersisterCategorie
import com.bav.airneisbackend.categorie.domain.usecase.RecupererCategorie
import com.bav.airneisbackend.categorie.domain.usecase.RecupererCategories
import com.bav.airneisbackend.categorie.userside.adaptater.controller.documentation.CategorieControllerDocumentation
import com.bav.airneisbackend.categorie.userside.dto.CategorieRestRessource
import com.bav.airneisbackend.categorie.userside.dto.PourCreerCategorieRestRessource
import com.bav.airneisbackend.categorie.userside.mapper.CategorieMapper.toCategorie
import com.bav.airneisbackend.categorie.userside.mapper.CategorieMapper.toCategorieRestRessource
import com.bav.airneisbackend.categorie.userside.mapper.CategorieMapper.toCollectionModel
import org.springframework.data.domain.PageRequest
import org.springframework.hateoas.CollectionModel
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
@RequestMapping("/airneis/categories")
class CategorieController(
    private val persisterCategorie: PersisterCategorie,
    private val recupererCategories: RecupererCategories,
    private val recupererCategorie: RecupererCategorie
) :  CategorieControllerDocumentation{

    @GetMapping
    override fun recupererCategories(
        @RequestParam(name = "page number", defaultValue = "0") pageNumber: Int,
        @RequestParam(name = "page size", defaultValue = "10") pageSize: Int
    ): ResponseEntity<CollectionModel<CategorieRestRessource>> {
        val pageable = PageRequest.of(pageNumber, pageSize)
        val categorieRecupere = recupererCategories(pageable)
        return ResponseEntity.ok(categorieRecupere.toCollectionModel())
    }

    @GetMapping("/{id}")
    override fun recupererCategorieParId(
        @PathVariable id: String
    ):
        ResponseEntity<CategorieRestRessource> {
        val categorieRecupere = recupererCategorie(id)
        return ResponseEntity.ok(categorieRecupere.toCategorieRestRessource())
    }


    @PostMapping
    override fun creerCategorie(@RequestBody categorieRestRessource: PourCreerCategorieRestRessource): ResponseEntity<CategorieRestRessource> {
        val categorieRecuperer = categorieRestRessource.toCategorie()

        val categoriePersiste = persisterCategorie(categorieRecuperer)
        val uriCategorie = "/airneis/categorie/${categoriePersiste.id}"
        val categoriePersisteRestRessource =  categoriePersiste.toCategorieRestRessource()
        return ResponseEntity.created(URI(uriCategorie)).body(categoriePersisteRestRessource)
    }

}