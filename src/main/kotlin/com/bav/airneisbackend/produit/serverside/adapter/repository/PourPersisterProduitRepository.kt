package com.bav.airneisbackend.produit.serverside.adapter.repository

import com.bav.airneisbackend.Materiaux.domain.exception.MateriauNonTrouveException
import com.bav.airneisbackend.Materiaux.domain.port.serverside.PourRecupererUnMateriau
import com.bav.airneisbackend.Materiaux.serverside.adapter.repository.RecupererUnMateriauRepository
import com.bav.airneisbackend.produit.domain.exception.MateriauDuProduitIntrouvable
import com.bav.airneisbackend.produit.domain.exception.ProduitInvalideException
import com.bav.airneisbackend.produit.domain.model.Materiau
import com.bav.airneisbackend.produit.domain.model.Produit
import com.bav.airneisbackend.produit.domain.port.serverside.produit.PourPersisterProduit
import com.bav.airneisbackend.produit.serverside.mapper.ProduitMapper.toProduit
import com.bav.airneisbackend.produit.serverside.mapper.ProduitMapper.toProduitDocument
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.stereotype.Repository


@Repository
class PourPersisterProduitRepository(
    val mongoTemplate: MongoTemplate, val pourRecupererUnMateriau: PourRecupererUnMateriau
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

            // TODO : AJOUTER LA VERIFICATION DE LA CATEGORIE

            if (champsManquants.isNotEmpty()) throw ProduitInvalideException("Les champs suivants sont manquants : $champsManquants",champsManquants)

            val produitValide =
                Produit(
                    id = produit.id,
                    prix = produit.prix,
                    nom = produit.nom,
                    description = produit.description,
                    dimension = produit.dimension,
                    categorie = produit.categorie,
                    images = produit.images,
                    materiaux = materiauxValides


                )

            val produitDocument = produitValide.toProduitDocument()
            val produitEnregistre = mongoTemplate.save(produitDocument)
            return produitEnregistre.toProduit()
        } catch (e: MateriauNonTrouveException) {
            throw MateriauDuProduitIntrouvable("Le materiau ${e.id} n'existe pas")
        }


    }
}

