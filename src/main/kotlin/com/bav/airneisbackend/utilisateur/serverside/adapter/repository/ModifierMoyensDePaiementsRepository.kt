package com.bav.airneisbackend.utilisateur.serverside.adapter.repository

import com.bav.airneisbackend.utilisateur.domain.model.MoyenDePaiement
import com.bav.airneisbackend.utilisateur.domain.model.Utilisateur
import com.bav.airneisbackend.utilisateur.domain.port.serverside.PourModifierMoyensDePaiementServerSidePort
import com.bav.airneisbackend.utilisateur.serverside.adapter.mongodb.repository.MongoDbUtilisateurRepository
import com.bav.airneisbackend.utilisateur.serverside.dto.UtilisateurDocument
import com.bav.airneisbackend.utilisateur.serverside.mapper.UtilisateurMapper.toUtilisateur
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Repository


@Repository
class ModifierMoyensDePaiementsRepository(val mongoDbUtilisateurRepository: MongoDbUtilisateurRepository) :
    PourModifierMoyensDePaiementServerSidePort {
    override fun invoke( paiements: List<MoyenDePaiement>): Utilisateur {
        val authentication = SecurityContextHolder.getContext().authentication

        val currentUser: UtilisateurDocument = authentication.principal as UtilisateurDocument
        val utilisateur = currentUser.copy(paiements = paiements)



        return mongoDbUtilisateurRepository.save(utilisateur).toUtilisateur()

    }
}