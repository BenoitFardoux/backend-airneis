package com.bav.airneisbackend.materiaux.serverside.adapter.repository

import com.bav.airneisbackend.materiaux.domain.exception.MateriauNonTrouveException
import com.bav.airneisbackend.materiaux.fixture.MateriauFixture
import com.bav.airneisbackend.materiaux.serverside.dto.MateriauDocument
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Query
import org.springframework.test.context.TestPropertySource


@SpringBootTest
@TestPropertySource("classpath:application-test.properties")
class RecupererUnMateriauRepositoryTest {
    @Autowired
    private lateinit var recupererUnMateriauRepository: RecupererUnMateriauRepository

    @Autowired
    private lateinit var mongoTemplate: MongoTemplate

    @BeforeEach
    fun setUp() {
        mongoTemplate.insert(MateriauFixture.materiauDocument)
    }

    @AfterEach
    fun tearDown() {
        mongoTemplate.remove(Query(), MateriauDocument::class.java)
    }

    @Test
    fun `Lorsque j'essaye de recuperer un materiau de la base de donnée je récupère le materiau`() {
        // GIVEN
        val materiau = MateriauFixture.materiau
        // WHEN
        val materiauRecupere = recupererUnMateriauRepository(materiau.id)
        // THEN
        assertThat(materiauRecupere).isEqualTo(materiau)
    }

    @Test
    fun `Lorsque j'essaye de recuperer un materiau de la base de donnée mais que le materiau n'existe pas je rencontre une errreur`() {
        // GIVEN
        val id = "123456"
        // WHEN
        // THEN
        assertThrows<MateriauNonTrouveException> { recupererUnMateriauRepository(id) }
    }

}