package com.bav.airneisbackend.config

import com.bav.airneisbackend.utils.JwtService
import com.mongodb.lang.NonNull
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import org.springframework.web.servlet.HandlerExceptionResolver


@Component
    class JwtAuthenticationFilter(
        private val jwtService: JwtService,
        private val userDetailsService: UserDetailsService,
        private val handlerExceptionResolver: HandlerExceptionResolver
    ) : OncePerRequestFilter() {

        //@Throws(ServletException::class, IOException::class)
        override fun doFilterInternal(
            @NonNull request: HttpServletRequest,
            @NonNull response: HttpServletResponse,
            @NonNull filterChain: FilterChain
        ) {
            val authHeader = request.getHeader("Authorization")

            if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                filterChain.doFilter(request, response)
                return
            }

            try {
                val jwt = authHeader.substring(7)
                val userEmail: String = jwtService.extractUsername(jwt)

                val authentication: Authentication? = SecurityContextHolder.getContext().authentication

                if (authentication == null) {
                    val userDetails = userDetailsService.loadUserByUsername(userEmail)

                    if (jwtService.isTokenValid(jwt, userDetails)) {
                        val authToken = UsernamePasswordAuthenticationToken(
                            userDetails,
                            null,
                            userDetails.authorities
                        )

                        authToken.details = WebAuthenticationDetailsSource().buildDetails(request)
                        SecurityContextHolder.getContext().authentication = authToken
                    }
                }

                filterChain.doFilter(request, response)
            } catch (exception: Exception) {
                response.status = HttpServletResponse.SC_INTERNAL_SERVER_ERROR

                response.contentType = "application/json"
                response.characterEncoding = "UTF-8"
                val jsonResponse = """{"error": "${exception.message}"}"""
                response.writer.write(jsonResponse)
                response.writer.flush()
                handlerExceptionResolver.resolveException(request, response, null, exception)

            }
        }
    }
