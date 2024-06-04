package com.bav.airneisbackend.utilisateur.serverside.adapter.repository

import com.bav.airneisbackend.utilisateur.domain.model.Adresse
import com.bav.airneisbackend.utilisateur.domain.model.Utilisateur
import com.bav.airneisbackend.utilisateur.domain.port.serverside.adresse.ModifierAdressesServerSidePort
import com.bav.airneisbackend.utilisateur.serverside.adapter.mongodb.repository.MongoDbUtilisateurRepository
import com.bav.airneisbackend.utilisateur.serverside.dto.UtilisateurDocument
import com.bav.airneisbackend.utilisateur.serverside.mapper.UtilisateurMapper.toUtilisateur
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Repository


@Repository
class ModifierAdressesRepository(val mongoDbUtilisateurRepository: MongoDbUtilisateurRepository) :
    ModifierAdressesServerSidePort {
    override fun invoke(adresses: List<Adresse>): Utilisateur {
        val authentication = SecurityContextHolder.getContext().authentication

        val currentUser: UtilisateurDocument = authentication.principal as UtilisateurDocument
        val utilisateur = currentUser.copy(adresse = adresses)
        return mongoDbUtilisateurRepository.save(utilisateur).toUtilisateur()

    }
}