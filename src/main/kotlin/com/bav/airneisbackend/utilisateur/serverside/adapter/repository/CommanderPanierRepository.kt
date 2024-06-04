package com.bav.airneisbackend.utilisateur.serverside.adapter.repository

import com.bav.airneisbackend.utilisateur.domain.model.Adresse
import com.bav.airneisbackend.utilisateur.domain.model.MoyenDePaiement
import com.bav.airneisbackend.utilisateur.domain.model.Panier
import com.bav.airneisbackend.utilisateur.domain.model.Utilisateur
import com.bav.airneisbackend.utilisateur.domain.port.serverside.CommanderPanierServerSidePort
import com.bav.airneisbackend.utilisateur.serverside.adapter.mongodb.repository.MongoDbUtilisateurRepository
import com.bav.airneisbackend.utilisateur.serverside.dto.UtilisateurDocument
import com.bav.airneisbackend.utilisateur.serverside.mapper.UtilisateurMapper.toUtilisateur
import org.bson.types.ObjectId
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Repository
import java.util.Date


@Repository
class CommanderPanierRepository(val mongoDbUtilisateurRepository: MongoDbUtilisateurRepository) : CommanderPanierServerSidePort {
    override fun invoke(adresse: Adresse, moyenDePaiement: MoyenDePaiement): Utilisateur {
        val authentication = SecurityContextHolder.getContext().authentication
        val currentUser = authentication.principal as UtilisateurDocument
        if (currentUser.panierActuel.produits.isEmpty()) {
            throw IllegalArgumentException("Le panier est vide")
        }

        val panierVide = Panier(
            id = ObjectId().toHexString(),
            produits = mutableListOf(),
        )


        val panierActuel = currentUser.panierActuel.copy(
            adresse = adresse,
            paiements = moyenDePaiement,
            dateDeCommande = Date(),
        )

        currentUser.commandes.add(panierActuel)


        val newUser = currentUser.copy(panierActuel = panierVide)

        mongoDbUtilisateurRepository.save(newUser)

        return newUser.toUtilisateur()
    }
}