package com.bav.airneisbackend.config

import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.web.cors.CorsConfiguration


@Configuration
@EnableWebSecurity
class SecurityConfiguration(
    private val authenticationProvider: AuthenticationProvider,
    private val jwtAuthenticationFilter: JwtAuthenticationFilter
) {
  @Bean
  fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
    http.csrf { it.disable() }
        .cors { it.configurationSource(corsConfigurationSource()) }
        .authorizeHttpRequests {
          it.requestMatchers(
              HttpMethod.POST,
              "/auth/register",
              "/auth/login"
          ).permitAll().requestMatchers(
              HttpMethod.GET,
              "/airneis/materiau/**",
              "/airneis/produits/**",
              "/airneis/categorie/**",
              "/actuator/**",
              "/swagger-ui/**",
              "/v3/api-docs/**"
          ).permitAll()
              .anyRequest().authenticated()
        }
        .sessionManagement {
          it.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        }
        .authenticationProvider(authenticationProvider)
        .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter::class.java)

    return http.build()
  }

  private fun corsConfigurationSource(): UrlBasedCorsConfigurationSource {
    val source = UrlBasedCorsConfigurationSource()
    val config = CorsConfiguration()
    config.allowedOriginPatterns = listOf("*")
    config.allowedHeaders = listOf("*")
    config.allowedMethods = listOf("GET", "PATCH", "POST", "PUT", "DELETE", "OPTIONS")
    source.registerCorsConfiguration("/**", config)
    return source
  }
}