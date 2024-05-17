package com.bav.airneisbackend.categorie.serverside.adapter.repository

import com.bav.airneisbackend.categorie.CategorieFixture
import com.bav.airneisbackend.categorie.domain.exception.CategorieInvalideException
import com.bav.airneisbackend.categorie.serverside.adapter.mongodb.repository.MongoDbCategorieRepository
import com.bav.airneisbackend.categorie.serverside.dto.CategorieDocument
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
class PourPersiterCategorieRepositoryTest {
    @Autowired
    private lateinit var pourPersiterCategorieRepository: PourPersiterCategorieRepository

    @Autowired
    private lateinit var mongoDbCategoriesRepository: MongoDbCategorieRepository

    @Autowired
    private lateinit var mongoTemplate: MongoTemplate

    @BeforeEach
    fun setUp() {
        mongoTemplate.insert(CategorieFixture.categorieDocument)
    }

    @AfterEach
    fun tearDown() {
        mongoTemplate.remove(Query(), CategorieDocument::class.java)
    }

    @Test
    fun `Lorsque j'essaye de persister une categorie dans la base de donnée je récupère la categorie`() {
        // GIVEN
        val categorie = CategorieFixture.uneCategorie
        // WHEN
        val categoriePersister = pourPersiterCategorieRepository(categorie)
        // THEN
        assertThat(categoriePersister.id).isNotEmpty()
        assertThat(categoriePersister).usingRecursiveComparison().ignoringFields("id").isEqualTo(categorie)

        mongoDbCategoriesRepository.findById(categoriePersister.id).get().let {
            assertThat(it).usingRecursiveComparison().isEqualTo(categoriePersister)
        }
    }

    @Test
    fun `lorsque j'essaye de persister une categorie invalide je recois une erreur`() {
        // GIVEN
        val categorie = CategorieFixture.categorieSansNom
        // WHEN // THEN
        assertThrows<CategorieInvalideException> { pourPersiterCategorieRepository(categorie) }.also { exception ->
            assertThat(exception.champs).isEqualTo(listOf("nom"))
        }
    }
}