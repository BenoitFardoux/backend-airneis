package com.bav.airneisbackend.categorie.serverside.adapter.repository

import com.bav.airneisbackend.categorie.CategorieFixture
import com.bav.airneisbackend.categorie.serverside.adapter.mongodb.repository.MongoDbCategorieRepository
import com.bav.airneisbackend.categorie.serverside.dto.CategorieDocument
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
class PourRecupererCategorieRepositoryTest{

  @Autowired
  private lateinit var pourRecupererCategorieRepository: PourRecupererCategorieRepository

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
  fun `Quand je veux récupérer mes catégories, je récupere toute les catégories présente dans la db`(){
    // GIVEN
    val pageable = PageRequest.of(0, 10)
    val categorieAttendu = PageImpl(listOf(CategorieFixture.uneCategorie))

    // WHEN
    val categorieRecupere = pourRecupererCategorieRepository(pageable)
    // THEN
    assertThat(categorieRecupere.content).isEqualTo(categorieAttendu.content)
  }
}