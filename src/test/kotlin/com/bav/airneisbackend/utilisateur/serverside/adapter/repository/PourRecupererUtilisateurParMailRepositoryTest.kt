package com.bav.airneisbackend.utilisateur.serverside.adapter.repository

import com.bav.airneisbackend.utilisateur.fixture.UtilisateurFixture
import com.bav.airneisbackend.utilisateur.serverside.adapter.mongodb.repository.MongoDbUtilisateurRepository
import com.bav.airneisbackend.utilisateur.serverside.exception.UtilisateurNonTrouveException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.test.context.TestPropertySource


@SpringBootTest
@TestPropertySource("classpath:application-test.properties")
class PourRecupererUtilisateurParMailRepositoryTest{
    @Autowired
    private lateinit var mongoDbUtilisateurRepository: MongoDbUtilisateurRepository

    @Autowired
    private lateinit var mongoTemplate: MongoTemplate

    @Autowired
    private lateinit var pourRecupererUtilisateurParMailRepository: PourRecupererUtilisateurParMailRepository

    @BeforeEach
    fun setUp() {
        mongoTemplate.insert(UtilisateurFixture.utilisateurDocument)
    }

    @AfterEach
    fun tearDown() {
        mongoDbUtilisateurRepository.deleteAll()
    }

    @Test
    fun `quand j'appelle ma fonction de rechreche d'utilisateur je récupére le bon utilisateur`() {
        // GIVEN
        val utilisateur = UtilisateurFixture.utilisateur
        val utilisateurARecuperer = utilisateur
        val email = utilisateur.email

        // WHEN
        val utilisateurTrouve = pourRecupererUtilisateurParMailRepository(email)
        // THEN
        assertThat(utilisateurTrouve).isEqualTo(utilisateurARecuperer)
    }

    @Test
    fun `quand j'appelle ma fonction de rechreche d'utilisateur avec un email qui n'existe pas je récupére une exception`() {
        // GIVEN
        val email = ""

        // WHEN
        assertThrows<UtilisateurNonTrouveException> { pourRecupererUtilisateurParMailRepository(email) }
    }

}