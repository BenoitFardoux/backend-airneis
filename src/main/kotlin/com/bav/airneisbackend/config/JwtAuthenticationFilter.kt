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
            System.err.println(exception.toString())
            response.status = HttpServletResponse.SC_INTERNAL_SERVER_ERROR
            response.contentType = "application/json"
            response.characterEncoding = "UTF-8"
            val jsonResponse = """{"error": "${exception.message}"}"""
            response.writer.apply {
                write(jsonResponse)
                flush()
            }
            handlerExceptionResolver.resolveException(request, response, null, exception)
        }
    }

    override fun shouldNotFilter(request: HttpServletRequest): Boolean {
        val path = request.requestURI
        val method = request.method
        val allowedGetPaths: Array<String> = SecurityConfiguration.PUBLIC_GET_REQUEST_MATCHERS
        val allowedPostPaths: Array<String> = SecurityConfiguration.PUBLIC_POST_REQUEST_MATCHERS

        // Check if the request is a GET request and matches the allowed GET paths
        if (method == "GET" && allowedGetPaths.any { allowedPath ->
                val sanitizedPath = allowedPath.replace("/*", "").replace("/**", "")
                path.contains(sanitizedPath)
            }) {
            return true
        }

        // Check if the request is a POST request and matches the allowed POST paths
        if (method == "POST" && allowedPostPaths.any { allowedPath ->
                val sanitizedPath = allowedPath.replace("/*", "").replace("/**", "")
                path.contains(sanitizedPath)
            }) {
            return true
        }

        return false
    }
}
