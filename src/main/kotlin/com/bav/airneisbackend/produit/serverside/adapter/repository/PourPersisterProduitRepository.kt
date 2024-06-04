package com.bav.airneisbackend.produit.serverside.adapter.repository

import com.bav.airneisbackend.Materiaux.domain.exception.MateriauNonTrouveException
import com.bav.airneisbackend.Materiaux.domain.port.serverside.PourRecupererUnMateriau
import com.bav.airneisbackend.categorie.serverside.adapter.mongodb.repository.MongoDbCategorieRepository
import com.bav.airneisbackend.categorie.serverside.adapter.repository.AjouterProduitACategorieRepository
import com.bav.airneisbackend.produit.domain.exception.MateriauDuProduitIntrouvable
import com.bav.airneisbackend.produit.domain.exception.ProduitInvalideException
import com.bav.airneisbackend.produit.domain.model.Materiau
import com.bav.airneisbackend.produit.domain.model.Produit
import com.bav.airneisbackend.produit.domain.port.serverside.produit.PourPersisterProduit
import com.bav.airneisbackend.produit.serverside.adapter.mongodb.repository.MongoDbProduitRepository
import com.bav.airneisbackend.produit.serverside.dto.ProduitDocument
import com.bav.airneisbackend.produit.serverside.exception.CategorieNonTrouveeException
import com.bav.airneisbackend.produit.serverside.mapper.ProduitMapper.toProduit
import com.bav.airneisbackend.produit.serverside.mapper.ProduitMapper.toProduitDocument
import org.springframework.stereotype.Repository


@Repository
class PourPersisterProduitRepository(
    val mongoDbProduitRepository: MongoDbProduitRepository,
    val mongoDbCategorieRepository: MongoDbCategorieRepository,
    val pourRecupererUnMateriau: PourRecupererUnMateriau,
    val ajouterProduitACategorieRepository: AjouterProduitACategorieRepository
) : PourPersisterProduit {
    override fun invoke(produit: Produit): Produit {
        val champsManquants = mutableListOf<String>()
        try {
            val materiauxValides = produit.materiaux.map {
                val materiau = pourRecupererUnMateriau(it.id); Materiau(
                materiau.id, materiau.nom
            )
            }
            if (produit.description.isEmpty()) {
                champsManquants.add("description")
            }
            if (produit.nom.isEmpty()) {
                champsManquants.add("nom")
            }
            if (produit.prix <= 0) {
                champsManquants.add("prix")
            }
            if (produit.materiaux.isEmpty()) {
                champsManquants.add("materiaux")
            }
            if (produit.categorie.id.isEmpty()) {
                champsManquants.add("categorie")
            }



            if (champsManquants.isNotEmpty()) throw ProduitInvalideException(
                "Les champs suivants sont manquants : $champsManquants", champsManquants
            )
            val produitValide = Produit(
                id = produit.id,
                prix = produit.prix,
                nom = produit.nom,
                description = produit.description,
                dimension = produit.dimension,
                categorie = produit.categorie,
                images = produit.images,
                materiaux = materiauxValides
            )

            lateinit var produitDocument : ProduitDocument

            if (mongoDbCategorieRepository.existsById(produit.categorie.id)) {
                produitDocument = produitValide.toProduitDocument()
                ajouterProduitACategorieRepository(produit.categorie.id, produitDocument.id)
            } else {
                throw CategorieNonTrouveeException("La categorie ${produit.categorie.id} n'existe pas")
            }


            val produitEnregistre = mongoDbProduitRepository.save(produitDocument)
            return produitEnregistre.toProduit()
        } catch (e: MateriauNonTrouveException) {
            throw MateriauDuProduitIntrouvable("Le materiau ${e.id} n'existe pas")
        }


    }
}

