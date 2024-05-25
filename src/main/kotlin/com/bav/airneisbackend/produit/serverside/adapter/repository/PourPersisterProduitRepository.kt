package com.bav.airneisbackend.produit.serverside.adapter.repository

import com.bav.airneisbackend.Materiaux.domain.exception.MateriauNonTrouveException
import com.bav.airneisbackend.Materiaux.domain.port.serverside.PourRecupererUnMateriau
import com.bav.airneisbackend.categorie.serverside.adapter.repository.PourRecupererUneCategorieRepository
import com.bav.airneisbackend.produit.domain.exception.MateriauDuProduitIntrouvable
import com.bav.airneisbackend.produit.domain.exception.ProduitInvalideException
import com.bav.airneisbackend.produit.domain.model.Categorie
import com.bav.airneisbackend.produit.domain.model.Materiau
import com.bav.airneisbackend.produit.domain.model.Produit
import com.bav.airneisbackend.produit.domain.port.serverside.produit.PourPersisterProduit
import com.bav.airneisbackend.produit.serverside.mapper.ProduitMapper.toProduit
import com.bav.airneisbackend.produit.serverside.mapper.ProduitMapper.toProduitDocument
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.stereotype.Repository


@Repository
class PourPersisterProduitRepository(
    val mongoTemplate: MongoTemplate,
    val pourRecupererUnMateriau: PourRecupererUnMateriau,
    val pourRecupererUneCategorieRepository: PourRecupererUneCategorieRepository
) : PourPersisterProduit {
    override fun invoke(produit: Produit): Produit {
        val champsManquants = mutableListOf<String>()
        try {
            val materiauxValides = produit.materiaux.map { val materiau =pourRecupererUnMateriau(it.id); Materiau(materiau.id, materiau.nom)}
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

            if(produit.categorie.id.isEmpty()){
                champsManquants.add("categorieId")
            }

            if (champsManquants.isNotEmpty()) throw ProduitInvalideException("Les champs suivants sont manquants : $champsManquants",champsManquants)

            val categorie = pourRecupererUneCategorieRepository(produit.categorie.id)

            val produitValide =
                with(produit){
                Produit(
                    id = id,
                    prix = prix,
                    nom = nom,
                    description = description,
                    dimension = dimension,
                    categorie = Categorie(
                        categorie.id,
                        categorie.nom
                    ),
                    images = images,
                    materiaux = materiauxValides
                )
            }
            val produitDocument = produitValide.toProduitDocument()
            val produitEnregistre = mongoTemplate.save(produitDocument)
            return produitEnregistre.toProduit()
        } catch (e: MateriauNonTrouveException) {
            throw MateriauDuProduitIntrouvable("Le materiau ${e.id} n'existe pas")
        }


    }
}

