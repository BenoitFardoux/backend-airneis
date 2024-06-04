package com.bav.airneisbackend.categorie.serverside.adapter.repository

import com.bav.airneisbackend.categorie.CategorieFixture
import com.bav.airneisbackend.categorie.serverside.adapter.mongodb.repository.MongoDbCategorieRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestPropertySource


@SpringBootTest
@TestPropertySource("classpath:application-test.properties")
class PourRecupererUneCategorieRepositoryTest {
    @Autowired
    lateinit var pourRecupererUneCategorieRepository: PourRecupererUneCategorieRepository

    @Autowired
    lateinit var mongoDbCategorieRepository: MongoDbCategorieRepository

    @BeforeEach
    fun setUp() {
        mongoDbCategorieRepository.save(CategorieFixture.categorieDocument)
    }

    @AfterEach
    fun tearDown() {
        mongoDbCategorieRepository.deleteAll()
    }

    @Test
    fun `Lorsque j'essaye de récupérer une categorie dans la base de donnée je récupère la categorie`() {
        // GIVEN
        val categorie = CategorieFixture.uneCategorie
        // WHEN
        val categorieRecupere = pourRecupererUneCategorieRepository(categorie.id)
        // THEN
        assertThat(categorieRecupere).usingRecursiveComparison().isEqualTo(categorie)
    }

}