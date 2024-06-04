package com.bav.airneisbackend.materiaux.serverside.adapter.repository

import com.bav.airneisbackend.materiaux.fixture.MateriauFixture
import com.bav.airneisbackend.materiaux.serverside.adapter.mongodb.repository.MongoDbMateriauxRepository
import com.bav.airneisbackend.materiaux.serverside.dto.MateriauDocument
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
class PersisterMateriauRepositoryTest{
    @Autowired
    private  lateinit var persisterMateriauRepository: PersisterMateriauRepository

    @Autowired
    private lateinit var mongoDbMateriauxRepository: MongoDbMateriauxRepository

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
    fun `Lorsque j'essaye de persister un materiau dans la base de donnée je récupère le materiau`(){
        // GIVEN
        val materiau = MateriauFixture.materiauSansId
        // WHEN
        val materiauPersister = persisterMateriauRepository(materiau)
        // THEN
        assertThat(materiauPersister.id).isNotEmpty()
        assertThat(materiauPersister).usingRecursiveComparison().ignoringFields("id").isEqualTo(materiau)

        mongoDbMateriauxRepository.findById(materiauPersister.id).get().let {
            assertThat(it).usingRecursiveComparison().isEqualTo(materiauPersister)
        }
    }

}