package com.bav.airneisbackend.utilisateur.serverside.adapter.repository

import com.bav.airneisbackend.utilisateur.domain.model.produits.Produit
import com.bav.airneisbackend.utilisateur.domain.port.serverside.PourSupprimerArticleDansPanierServerSidePort
import com.bav.airneisbackend.utilisateur.serverside.adapter.mongodb.repository.MongoDbUtilisateurRepository
import com.bav.airneisbackend.utilisateur.serverside.dto.UtilisateurDocument
import com.bav.airneisbackend.utilisateur.serverside.exception.ProduitIntrouvableDansPanierException
import com.bav.airneisbackend.utilisateur.serverside.mapper.UtilisateurMapper.toUtilisateur
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Repository


@Repository
class SupprimerArticleDansPanierRepository(
    val mongoDbUtilisateurRepository: MongoDbUtilisateurRepository
) : PourSupprimerArticleDansPanierServerSidePort {
    override operator fun invoke(idArticle: String): Produit {
        val authentication = SecurityContextHolder.getContext().authentication

        val currentUser: UtilisateurDocument = authentication.principal as UtilisateurDocument
        // Find the product in the current user's cart
        val produit = currentUser.panierActuel.produits.find { it.id == idArticle }
            ?: throw ProduitIntrouvableDansPanierException(idArticle)
        currentUser.panierActuel.produits.remove(produit)

        mongoDbUtilisateurRepository.save(currentUser).toUtilisateur()
        // Assuming there's a method to convert UtilisateurDocument to Utilisateur
        return produit
    }

}