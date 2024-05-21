package com.bav.airneisbackend.utilisateur.serverside.dto

import com.bav.airneisbackend.utilisateur.domain.model.Adresse
import com.bav.airneisbackend.utilisateur.domain.model.Paiments
import com.bav.airneisbackend.utilisateur.domain.model.Panier
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.MongoId
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails


@Document("Utilisateur")
data class UserDocument(
    @MongoId val id: String = "",
    val username: String,
    val password: String,
    val verifie : Boolean,
    val email: String,
    val nom : String,
    val prenom : String,
    val paiements : List<Paiments> = emptyList(),
    val numeroDeTelephone : String,
    val addresse : List<Adresse> = emptyList(),
    val panierActuel : Panier,
    val commandes : List<Panier> = emptyList()
) : UserDetails {
    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return mutableListOf()
    }

    override fun getPassword(): String {
        return password
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

