package com.bav.airneisbackend.Produit.serverside.adapter.repository

import com.bav.airneisbackend.Produit.domain.exception.AucunProduitTrouveException
import com.bav.airneisbackend.Produit.fixture.ProduitFixture
import com.bav.airneisbackend.Produit.serverside.dto.ProduitDocument
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Query


@SpringBootTest

class PourRecupererUnProduitRepositoryTest {
    @Autowired
    private lateinit var mongoTemplate: MongoTemplate

    @Autowired
    private lateinit var pourRecupererUnProduitRepository: PourRecupererUnProduitRepository
    @BeforeEach
    fun setUp() {
        mongoTemplate.insert(ProduitFixture.produitDocument)
    }

    @AfterEach
    fun tearDown() {
        mongoTemplate.remove(Query(), ProduitDocument::class.java)
    }


    @Test
    fun `quand j'appelle ma base de données pour récuperer un produit du référentiel, je récupère un produit`() {
        //GIVEN
        val produitARecuperer = ProduitFixture.produit
        val id = "123456"
        // WHEN
        val produitRecupere = pourRecupererUnProduitRepository(id)
        // THEN
        assertThat(produitRecupere).usingRecursiveComparison().isEqualTo(produitARecuperer)
    }

    @Test
    fun `quand j'appelle ma base de données pour récuperer un produit du referentiel mais qu'aucun id ne correspond je rencontre une erreur`() {
        //GIVEN
        val id = "1234567"
        // WHEN
        // THEN
        assertThrows<AucunProduitTrouveException>{pourRecupererUnProduitRepository(id)}
    }
}