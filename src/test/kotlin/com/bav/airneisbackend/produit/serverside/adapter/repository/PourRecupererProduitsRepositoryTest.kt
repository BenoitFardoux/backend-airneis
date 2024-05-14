package com.bav.airneisbackend.produit.serverside.adapter.repository

import com.bav.airneisbackend.produit.fixture.ProduitFixture
import com.bav.airneisbackend.produit.serverside.dto.ProduitDocument
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Query
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.springframework.test.context.TestPropertySource


@SpringBootTest
@TestPropertySource("classpath:application-test.properties")

class
PourRecupererProduitsRepositoryTest {

    @Autowired
    private lateinit var pourRecupererProduitsRepository: PourRecupererProduitsRepository

    @Autowired
    private lateinit var mongoTemplate: MongoTemplate

    @BeforeEach
    fun setUp() {
        mongoTemplate.insert(ProduitFixture.produitDocument)
    }

    @AfterEach
    fun tearDown() {
        mongoTemplate.remove(Query(), ProduitDocument::class.java)
    }

    @Test
    fun `quand j'appelle ma base de données pour récuperer les produits du référentiel, je récupère des pages de produits`() {
        //GIVEN
        val produitARecuperer = ProduitFixture.produit
        val pageDeProduitARecuperer = PageImpl(listOf(produitARecuperer))
        val pageable = PageRequest.of(0, 1)
        // WHEN
        val produitsRecupere = pourRecupererProduitsRepository(pageable)
        // THEN
        assertThat(produitsRecupere).usingRecursiveComparison().isEqualTo(pageDeProduitARecuperer)
    }

}