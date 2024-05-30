package com.bav.airneisbackend.utilisateur.serverside.adapter.repository

import com.bav.airneisbackend.utilisateur.domain.model.Panier
import com.bav.airneisbackend.utilisateur.domain.model.Utilisateur
import com.bav.airneisbackend.utilisateur.domain.port.serverside.ModifierPanierServerSidePort
import com.bav.airneisbackend.utilisateur.serverside.adapter.mongodb.repository.MongoDbUtilisateurRepository
import com.bav.airneisbackend.utilisateur.serverside.dto.UtilisateurDocument
import com.bav.airneisbackend.utilisateur.serverside.mapper.UtilisateurMapper.toUtilisateur
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Repository

@Repository
class ModifierPanierRepository(val mongoDbUtilisateurRepository: MongoDbUtilisateurRepository) : ModifierPanierServerSidePort {
    override fun invoke(panier: Panier): Utilisateur {
        val authentication = SecurityContextHolder.getContext().authentication
        val currentUser = authentication.principal as UtilisateurDocument
        val panierActuel = currentUser.panierActuel

        val newPanier = panierActuel.copy(
            produits = panier.produits.ifEmpty { panierActuel.produits },
            adresse = panier.adresse ?: panierActuel.adresse,
            paiements = panier.paiements ?: panierActuel.paiements,
            dateDeCommande = panier.dateDeCommande ?: panierActuel.dateDeCommande,
            dateDeLivraison = panier.dateDeLivraison ?: panierActuel.dateDeLivraison
        )

        val newUtilisateur = currentUser.copy(panierActuel = newPanier)

        return mongoDbUtilisateurRepository.save(newUtilisateur).toUtilisateur()
    }
}
