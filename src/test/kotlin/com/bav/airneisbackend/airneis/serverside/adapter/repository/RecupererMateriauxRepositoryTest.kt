package com.bav.airneisbackend.airneis.serverside.adapter.repository

import com.bav.airneisbackend.airneis.domain.model.Materiau
import com.bav.airneisbackend.airneis.domain.port.serverside.PourRecupererMateriauxServersidePort
import com.bav.airneisbackend.airneis.fixture.MateriauFixture
import com.bav.airneisbackend.airneis.serverside.adapter.mongodb.repository.MongoDbMateriauxRepository
import com.bav.airneisbackend.airneis.serverside.dto.MateriauDocument
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Profile
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Query
import org.springframework.test.context.TestPropertySource
import org.springframework.test.context.junit.jupiter.SpringExtension

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
    fun `le test est là pour voir si ça compile`() {
        // GIVEN
        val materiau = MateriauFixture.materiau
        val materiauARecuperer = PageImpl(listOf(materiau))
        val pageable = PageRequest.of(0, 1)
        // WHEN
        val materiauRecupere = recupererMateriauxRepository.recupererMateriaux(pageable)
        // THEN

        assertThat(materiauRecupere).usingRecursiveComparison().isEqualTo(materiauARecuperer)
    }
}