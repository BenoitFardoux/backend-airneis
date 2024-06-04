package com.bav.airneisbackend.categorie.userside.adaptater.controller

import com.bav.airneisbackend.categorie.domain.model.Image
import com.bav.airneisbackend.categorie.domain.usecase.PersisterCategorie
import com.bav.airneisbackend.categorie.userside.adaptater.controller.documentation.CategorieControllerDocumentation
import com.bav.airneisbackend.categorie.userside.dto.CategorieRestRessource
import com.bav.airneisbackend.categorie.userside.dto.PourCreerCategorieRestRessource
import com.bav.airneisbackend.categorie.userside.dto.ProduitPourCategorieRestRessource
import com.bav.airneisbackend.categorie.userside.mapper.CategorieMapper.toCategorie
import com.bav.airneisbackend.categorie.userside.mapper.CategorieMapper.toCategorieRestRessource
import com.bav.airneisbackend.produit.domain.usecase.RecupererUnProduit
import org.springframework.hateoas.CollectionModel
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI


@RestController
@RequestMapping("/airneis/categorie")
class CategorieController(
    private val persisterCategorie: PersisterCategorie,
    private val recupererProduit: RecupererUnProduit
) : CategorieControllerDocumentation {
    // TODO : implementer route post
    override fun recupererCategories(): ResponseEntity<CollectionModel<CategorieRestRessource>> {
        TODO("Not yet implemented")
    }

    override fun recupererCategorieParId(id: String): ResponseEntity<CategorieRestRessource> {
        TODO("Not yet implemented")
    }


    @PostMapping
    override fun creerCategorie(@RequestBody categorieRestRessource: PourCreerCategorieRestRessource): ResponseEntity<CategorieRestRessource> {
        val categorieRecuperer = categorieRestRessource.toCategorie()



        val categoriePersiste = persisterCategorie(categorieRecuperer)

        val uriCategorie = "/airneis/categorie/${categoriePersiste.id}"
        val produits = categoriePersiste.produits.map { recupererProduit(it.id) }.map {
            ProduitPourCategorieRestRessource(
                it.id,
                it.nom,
                it.description,
                it.prix,
                Image(it.images[0].url, it.images[0].description)
            )
        }
        val categoriePersisteRestRessource = categoriePersiste.toCategorieRestRessource(produits)
        return ResponseEntity.created(URI(uriCategorie)).body(categoriePersisteRestRessource)
    }

}