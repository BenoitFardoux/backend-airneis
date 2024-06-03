package com.bav.airneisbackend.categorie.serverside.adapter.repository

import com.bav.airneisbackend.categorie.domain.exception.CategorieInvalideException
import com.bav.airneisbackend.categorie.domain.model.Categorie
import com.bav.airneisbackend.categorie.domain.model.Image
import com.bav.airneisbackend.categorie.domain.model.Produit
import com.bav.airneisbackend.categorie.domain.port.serverside.categorie.PourPersisterCategorie
import com.bav.airneisbackend.categorie.serverside.adapter.mongodb.repository.MongoDbCategorieRepository
import com.bav.airneisbackend.categorie.domain.exception.ProduitIntrouvableException
import com.bav.airneisbackend.categorie.serverside.mapper.CategorieMapper.toCategorie
import com.bav.airneisbackend.categorie.serverside.mapper.CategorieMapper.toCategorieDocument
import com.bav.airneisbackend.produit.serverside.adapter.mongodb.repository.MongoDbProduitRepository
import org.springframework.stereotype.Repository
import kotlin.jvm.optionals.getOrElse


@Repository
class PourPersiterCategorieRepository(
    val mongoDbCategorieRepository: MongoDbCategorieRepository,
    val mongoDbProduitRepository: MongoDbProduitRepository
) : PourPersisterCategorie {
    override fun invoke(categorie: Categorie): Categorie {
        val champsInvalides = mutableListOf<String>()
        if (categorie.nom.isBlank()) {
            champsInvalides.add("nom")
        }
        if (categorie.image.url.isBlank() || categorie.image.description.isBlank()) {
            champsInvalides.add("image")
        }
        if (champsInvalides.isNotEmpty()) {
            throw CategorieInvalideException(description = "des champs sont invalides", champs = champsInvalides)
        }

        categorie.produits.map {
                val produit = mongoDbProduitRepository.findById(it.id).getOrElse {
                    throw ProduitIntrouvableException(it.id)
                }
                Produit(
                    id = produit.id,
                    nom = produit.nom,
                    description = produit.description,
                    image = Image(
                        url = produit.images[0].url,
                        description = produit.images[0].description

                    ),
                    prix = produit.prix
                )

        }

        val categorieDocument = categorie.toCategorieDocument()
        return mongoDbCategorieRepository.save(categorieDocument).toCategorie()
    }

}