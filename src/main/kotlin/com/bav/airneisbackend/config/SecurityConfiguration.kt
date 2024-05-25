    package com.bav.airneisbackend.config

    import org.springframework.context.annotation.Bean
    import org.springframework.context.annotation.Configuration
    import org.springframework.security.authentication.AuthenticationProvider
    import org.springframework.security.config.annotation.web.builders.HttpSecurity
    import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
    import org.springframework.security.config.http.SessionCreationPolicy
    import org.springframework.security.web.SecurityFilterChain
    import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter


    @Configuration
    @EnableWebSecurity
    class SecurityConfiguration(
        private val authenticationProvider: AuthenticationProvider,
        private val jwtAuthenticationFilter: JwtAuthenticationFilter
    ) {
        @Bean
        fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
            http.csrf { it.disable() }
                .authorizeHttpRequests {
                    it.requestMatchers("/auth/register", "/auth/login" ,  "/actuator/**", "/swagger-ui/**", "/v3/api-docs/**").permitAll()
                        .anyRequest().authenticated()
                }
                .sessionManagement {
                    it.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                }
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter::class.java)

            return http.build()
        }
    }