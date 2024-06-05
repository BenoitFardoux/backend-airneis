package com.bav.airneisbackend.utilisateur.serverside.dto

import com.bav.airneisbackend.utilisateur.domain.model.Adresse
import com.bav.airneisbackend.utilisateur.domain.model.MoyenDePaiement
import com.bav.airneisbackend.utilisateur.domain.model.Panier
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.MongoId
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails


@Document("Utilisateur")
data class UtilisateurDocument(
    @MongoId val id: String = "",
    val verifie : Boolean,
    val motDePasse : String,
    val email: String,
    val nom : String,
    val prenom : String,
    val paiements : List<MoyenDePaiement> = emptyList(),
    val numeroDeTelephone : String,
    val adresse : MutableList<Adresse> = mutableListOf(),
    val panierActuel : Panier,
    val roles: Set<String> = setOf(), // Ajouter les rôles ici
    val commandes : MutableList<Panier> = mutableListOf()
) : UserDetails {
    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return roles.map { SimpleGrantedAuthority("ROLE_$it") }.toMutableList()
    }

    override fun getPassword(): String {
        return motDePasse
    }
    override fun getUsername(): String {
        return email
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }
}

