package com.bav.airneisbackend.Materiaux.serverside.adapter.repository

import com.bav.airneisbackend.Materiaux.domain.model.Materiau
import com.bav.airneisbackend.Materiaux.fixture.MateriauFixture
import com.bav.airneisbackend.Materiaux.serverside.adapter.mongodb.repository.MongoDbMateriauxRepository
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


    @BeforeEach
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
        val materiauARecuperer : Page<Materiau> = PageImpl(listOf(materiau))
        val pageable = PageRequest.of(0, 1)
        val critereDeRecherche = "ch"

        // WHEN
        val materiauTrouve = recupererMateriauxParMotCleRepository(pageable,critereDeRecherche).content
        // THEN
        assertThat(materiauTrouve).isEqualTo(materiauARecuperer)
    }
}