package com.bav.airneisbackend.categorie.serverside.adapter.repository

import com.bav.airneisbackend.categorie.domain.exception.CategorieInvalideException
import com.bav.airneisbackend.categorie.domain.model.Categorie
import com.bav.airneisbackend.categorie.domain.model.Produit
import com.bav.airneisbackend.categorie.domain.port.serverside.categorie.PourPersisterCategorie
import com.bav.airneisbackend.categorie.serverside.mapper.CategorieMapper.toCategorie
import com.bav.airneisbackend.categorie.serverside.mapper.CategorieMapper.toCategorieDocument
import com.bav.airneisbackend.produit.domain.port.serverside.produit.PourRecupererProduitParId
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.stereotype.Repository


@Repository
class PourPersiterCategorieRepository(val mongoTemplate: MongoTemplate, val pourRecupererProduitParId: PourRecupererProduitParId) : PourPersisterCategorie {
    override fun invoke(categorie: Categorie): Categorie {
        val champsInvalides = mutableListOf<String>()
        if (categorie.nom.isBlank()){
            champsInvalides.add("nom")
        }
        if (categorie.image.url.isBlank() ||categorie.image.description.isBlank()){
            champsInvalides.add("image")
        }
        if (champsInvalides.isNotEmpty()){
            throw CategorieInvalideException(description = "des champs sont invalides", champs = champsInvalides)
        }

        val produits  = categorie.produit.map {
            try {
                val produit = pourRecupererProduitParId(it.id)
                Produit(produit.id, produit.nom)
            } catch (e: Exception){
                throw CategorieInvalideException(description = "un produit n'existe pas", champs = listOf("produit"))
            }
        }

        val categorieDocument = categorie.toCategorieDocument()
        return mongoTemplate.save(categorieDocument).toCategorie(produits)
    }

}