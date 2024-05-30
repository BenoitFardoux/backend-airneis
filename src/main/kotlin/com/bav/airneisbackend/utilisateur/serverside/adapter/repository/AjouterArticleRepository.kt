package com.bav.airneisbackend.utilisateur.serverside.adapter.repository

import com.bav.airneisbackend.produit.serverside.adapter.mongodb.repository.MongoDbProduitRepository
import com.bav.airneisbackend.utilisateur.domain.model.Utilisateur
import com.bav.airneisbackend.utilisateur.domain.model.produits.Produit
import com.bav.airneisbackend.utilisateur.domain.port.serverside.AjouterArticleDansPanierUtilisateurServerSidePort
import com.bav.airneisbackend.utilisateur.serverside.adapter.mongodb.repository.MongoDbUtilisateurRepository
import com.bav.airneisbackend.utilisateur.serverside.dto.UtilisateurDocument
import com.bav.airneisbackend.utilisateur.serverside.exception.ProduitInnexistantException
import com.bav.airneisbackend.utilisateur.serverside.mapper.UtilisateurMapper.toUtilisateur

import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Repository

@Repository
class AjouterArticleRepository(
    val mongoDbProduitRepository: MongoDbProduitRepository,
    val mongoDbUtilisateurRepository: MongoDbUtilisateurRepository
) : AjouterArticleDansPanierUtilisateurServerSidePort {
    override fun invoke(idArticle: String, quantite : Int): Utilisateur {
        mongoDbProduitRepository.existsById(idArticle).takeIf { !it }?.let {
            throw ProduitInnexistantException(idArticle)
        }

        val authentication = SecurityContextHolder.getContext().authentication

        val currentUser: UtilisateurDocument = authentication.principal as UtilisateurDocument
        currentUser.panierActuel.produits.filter { it.id == idArticle }.takeIf { it.isNotEmpty() }?.let {
            it.first().quantite += quantite

        } ?: run {
            val produit = Produit(idArticle, quantite)
            currentUser.panierActuel.produits.addLast(produit)

        }
        return mongoDbUtilisateurRepository.save(currentUser).toUtilisateur()
    }
}
