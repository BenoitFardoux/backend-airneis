package com.bav.airneisbackend.airneis.userside.configuration.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class SecurityConfiguration {

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http.csrf { csrf -> csrf.disable() }
            .authorizeHttpRequests { authorize ->
                authorize.requestMatchers(
                    "/actuator/**", "/swagger-ui/**", "/v3/api-docs/**", "/referentiel/**"
                )
                    .permitAll()
            }
        return http.build()
    }
}