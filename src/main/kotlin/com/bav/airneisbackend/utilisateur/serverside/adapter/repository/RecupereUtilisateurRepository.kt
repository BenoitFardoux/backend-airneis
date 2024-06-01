package com.bav.airneisbackend.utilisateur.serverside.adapter.repository

import com.bav.airneisbackend.produit.serverside.adapter.mongodb.repository.MongoDbProduitRepository
import com.bav.airneisbackend.utilisateur.domain.model.Utilisateur
import com.bav.airneisbackend.utilisateur.domain.port.serverside.PourRecupererUtilisateurServerSidePort
import com.bav.airneisbackend.utilisateur.serverside.adapter.mongodb.repository.MongoDbUtilisateurRepository
import com.bav.airneisbackend.utilisateur.serverside.dto.UtilisateurDocument
import com.bav.airneisbackend.utilisateur.serverside.mapper.UtilisateurMapper.toUtilisateur
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Repository

@Repository
class RecupereUtilisateurRepository(val mongoDbProduitRepository: MongoDbProduitRepository, val mongoDbUtilisateurRepository: MongoDbUtilisateurRepository) : PourRecupererUtilisateurServerSidePort {
    override fun invoke(): Utilisateur {
        val authentication = SecurityContextHolder.getContext().authentication
        val currentUser = authentication.principal as UtilisateurDocument
        var hasChanged = false

        val iterator = currentUser.panierActuel.produits.iterator()
        while (iterator.hasNext()) {
            val produit = iterator.next()
            if (!mongoDbProduitRepository.existsById(produit.id)) {
                iterator.remove()
                hasChanged = true
            }
        }

        if (hasChanged) {
            mongoDbUtilisateurRepository.save(currentUser)
        }

        return currentUser.toUtilisateur()
    }
}
