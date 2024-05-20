package com.bav.airneisbackend.utilisateur.serverside.adapter.repository

import com.bav.airneisbackend.utilisateur.domain.port.serverside.PourSeConnecterServerSidePort
import com.bav.airneisbackend.utils.JwtUtil
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Repository


@Repository
class SeConnecterRepository(
    private val authenticationManager: AuthenticationManager,
    private val userDetailsService: UserDetailsService,
    private val jwtUtil: JwtUtil
) : PourSeConnecterServerSidePort{
    override fun invoke(email: String, motDePasse: String) : String{
        authenticationManager.authenticate(
            UsernamePasswordAuthenticationToken(email, motDePasse)
        )
        val userDetails: UserDetails = userDetailsService.loadUserByUsername(email)
        return jwtUtil.generateToken(userDetails.username)

    }
}