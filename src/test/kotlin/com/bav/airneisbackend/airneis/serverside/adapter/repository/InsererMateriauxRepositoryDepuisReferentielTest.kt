package com.bav.airneisbackend.airneis.serverside.adapter.repository

import com.bav.airneisbackend.airneis.fixture.MateriauFixture
import com.bav.airneisbackend.airneis.serverside.dto.MateriauDocument
import com.bav.airneisbackend.airneis.serverside.dto.ReferentielDeMateriauDocument
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Query
import org.springframework.test.context.TestPropertySource


@SpringBootTest
@TestPropertySource("classpath:application-test.properties")
class InsererMateriauxRepositoryDepuisReferentielTest{
    @Autowired
    private lateinit var insererMateriauxRepository: InsererMateriauxRepositoryDepuisReferentiel

    @Autowired
    private lateinit var mongoTemplate: MongoTemplate

    @BeforeEach
    fun setUp() {
        mongoTemplate.insert(MateriauFixture.referentielDeMateriauDocument)
    }

    @AfterEach
    fun tearDown() {
        mongoTemplate.remove(Query(), ReferentielDeMateriauDocument::class.java)
        mongoTemplate.remove(Query(), MateriauDocument::class.java)
    }

    @Test
    fun `losque j'appelle ma fonction inserermateriaux() elle m'envoie une erreur not implemented`(){
        // GIVEN
        val materiauAInserer = MateriauFixture.materiauDocument
        val nombreDeMateriauACreer =  1
        // WHEN
        val nombreMateriauCree = insererMateriauxRepository.insererMateriaux()
        val materiauxInsere = mongoTemplate.findOne(Query(), MateriauDocument::class.java,"materiau")
        //THEN
        assertThat(nombreMateriauCree).isEqualTo(nombreDeMateriauACreer)
        assertThat(materiauxInsere).usingRecursiveComparison().ignoringFields("id").isEqualTo(materiauAInserer)
    }
}