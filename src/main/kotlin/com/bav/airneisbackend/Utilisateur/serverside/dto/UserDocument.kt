package com.bav.airneisbackend.Utilisateur.serverside.dto

import com.bav.airneisbackend.Utilisateur.domain.model.Adresse
import com.bav.airneisbackend.Utilisateur.domain.model.Paiments
import com.bav.airneisbackend.Utilisateur.domain.model.Panier
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
        TODO("Not yet implemented")
    }

    override fun getPassword(): String {
        TODO("Not yet implemented")
    }

    override fun getUsername(): String {
        TODO("Not yet implemented")
    }

    override fun isAccountNonExpired(): Boolean {
        TODO("Not yet implemented")
    }

    override fun isAccountNonLocked(): Boolean {
        TODO("Not yet implemented")
    }

    override fun isCredentialsNonExpired(): Boolean {
        TODO("Not yet implemented")
    }

    override fun isEnabled(): Boolean {
        TODO("Not yet implemented")
    }
}

