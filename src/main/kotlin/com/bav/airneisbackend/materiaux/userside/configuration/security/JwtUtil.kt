package com.bav.airneisbackend.materiaux.userside.configuration.security
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import org.springframework.stereotype.Component
import java.util.*
import javax.crypto.SecretKey

@Component
class JwtUtil {

    private val secretKey: SecretKey =  Jwts.SIG.HS256.key().build()

    fun extractUsername(token: String): String {
        return extractClaim(token) { it.subject }
    }

    fun extractExpiration(token: String): Date {
        return extractClaim(token) { it.expiration }
    }

    fun <T> extractClaim(token: String, claimsResolver: (Claims) -> T): T {
        val claims = extractAllClaims(token)
        return claimsResolver(claims)
    }

    private fun extractAllClaims(token: String): Claims {
        return Jwts.parser()
            .verifyWith(secretKey)
            .build()
            .parseSignedClaims(token)
            .payload
    }

    private fun isTokenExpired(token: String): Boolean {
        return extractExpiration(token).before(Date())
    }

    fun generateToken(username: String): String {
        val claims: Map<String, Any> = HashMap()
        return createToken(claims, username)
    }

    private fun createToken(claims: Map<String, Any>, subject: String): String {
        return Jwts.builder()
            .claims(claims)
            .subject(subject)
            .issuedAt(Date(System.currentTimeMillis()))
            .expiration(Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 hours
            .signWith(secretKey)
            .compact()
    }

    fun validateToken(token: String, username: String): Boolean {
        val tokenUsername = extractUsername(token)
        return (tokenUsername == username && !isTokenExpired(token))
    }
}
