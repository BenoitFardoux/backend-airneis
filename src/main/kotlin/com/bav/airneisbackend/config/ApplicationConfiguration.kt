package com.bav.airneisbackend.config

import com.bav.airneisbackend.utilisateur.domain.usecase.RecupererUtilisateurParMail
import com.bav.airneisbackend.utilisateur.serverside.mapper.UtilisateurMapper.toUtilisateurDocument
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder


@Configuration

class ApplicationConfiguration(val recupererUtilisateurParMail: RecupererUtilisateurParMail) {
    @Bean
    fun userDetailsService(): UserDetailsService {
        return UserDetailsService { email ->
            recupererUtilisateurParMail(email).toUtilisateurDocument()
        }
    }

    @Bean
    fun passwordEncoder(): BCryptPasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Bean
    fun authenticationManager(config: AuthenticationConfiguration): AuthenticationManager {
        return config.authenticationManager
    }

    @Bean
    fun authenticationProvider(): AuthenticationProvider {
        val authProvider = DaoAuthenticationProvider()

        authProvider.setUserDetailsService(userDetailsService())
        authProvider.setPasswordEncoder(passwordEncoder())

        return authProvider
    }
}

// TODO : JwtAuthenticationFilter et la security Configuration