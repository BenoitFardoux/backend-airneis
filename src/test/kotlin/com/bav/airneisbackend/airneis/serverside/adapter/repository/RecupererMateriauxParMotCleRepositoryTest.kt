package com.bav.airneisbackend.airneis.serverside.adapter.repository

import com.bav.airneisbackend.airneis.domain.model.Materiau
import com.bav.airneisbackend.airneis.fixture.MateriauFixture
import com.bav.airneisbackend.airneis.serverside.adapter.mongodb.repository.MongoDbMateriauxRepository
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.insert
import org.springframework.test.context.TestPropertySource


@SpringBootTest
@TestPropertySource("classpath:application-test.properties")
class RecupererMateriauxParMotCleRepositoryTest{
    @Autowired
    private lateinit var mongoTemplate : MongoTemplate

    @Autowired
    private lateinit var mongoDbMateriauxRepository: MongoDbMateriauxRepository

    @Autowired
    private lateinit var recupererMateriauxParMotCleRepository: RecupererMateriauxParMotCleRepository

    fun setUp() {
        mongoTemplate.insert(MateriauFixture.materiauDocument)
    }

    @AfterEach
    fun tearDown() {
        mongoDbMateriauxRepository.deleteAll()
    }


    @Test
    fun `quand j'appelle ma fonction de rechreche de materiau je récupére le bon matériaux`(){
        // GIVEN
        val materiau = MateriauFixture.materiau
        val materiauARecuperer = PageImpl(listOf(materiau))
        val pageable = PageRequest.of(0, 1)
        val critereDeRecherche = "bo"

        // WHEN
        val materiauTrouve = recupererMateriauxParMotCleRepository.recupererMateriauxParMotCle(pageable,critereDeRecherche)
        // THEN
        assertThat(materiauTrouve).usingRecursiveComparison().isEqualTo(Page.empty<Materiau>())
    }
}