package com.bav.airneisbackend.Materiaux.serverside.adapter.repository

import com.bav.airneisbackend.Materiaux.fixture.MateriauFixture
import com.bav.airneisbackend.Materiaux.serverside.dto.MateriauDocument
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import org.springframework.data.mongodb.core.MongoTemplate

import org.springframework.data.mongodb.core.query.Query
import org.springframework.test.context.TestPropertySource

@SpringBootTest
@TestPropertySource("classpath:application-test.properties")
class RecupererMateriauxRepositoryTest {
    @Autowired
    private lateinit var mongoTemplate: MongoTemplate


    @Autowired
    private lateinit var recupererMateriauxRepository: RecupererMateriauxRepository


    @BeforeEach
    fun setUp() {
        mongoTemplate.insert(MateriauFixture.materiauDocument)
    }

    @AfterEach
    fun tearDown() {
        mongoTemplate.remove(Query(), MateriauDocument::class.java)
    }


    @Test
    fun `Lorsque j'essaye de récuperer les materiaux de la base de donnée je récupère tous les materiaux paginés`() {
        // GIVEN
        val materiau = MateriauFixture.materiau
        val materiauARecuperer = PageImpl(listOf(materiau))
        val pageable = PageRequest.of(0, 1)
        // WHEN
        val materiauRecupere = recupererMateriauxRepository(pageable)
        // THEN

        assertThat(materiauRecupere).usingRecursiveComparison().ignoringFields("id").isEqualTo(materiauARecuperer)
    }
}