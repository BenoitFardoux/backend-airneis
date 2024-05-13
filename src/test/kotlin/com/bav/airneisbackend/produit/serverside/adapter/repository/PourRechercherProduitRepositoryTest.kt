package com.bav.airneisbackend.produit.serverside.adapter.repository

import com.bav.airneisbackend.produit.domain.model.Produit
import com.bav.airneisbackend.produit.fixture.ProduitFixture
import com.bav.airneisbackend.produit.serverside.dto.ProduitDocument
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import org.springframework.test.context.TestPropertySource
import org.junit.jupiter.api.assertThrows
import org.springframework.data.domain.Page
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.remove


@SpringBootTest
@TestPropertySource("classpath:application-test.properties")
class PourRechercherProduitRepositoryTest{
    @Autowired
    private lateinit var rechercherProduitRepository: PourRechercherProduitRepository

    @Autowired
    private lateinit var mongoTemplate: MongoTemplate

    @BeforeEach
    fun setUp(){
        mongoTemplate.insert(ProduitFixture.produitDocument)
    }

    @AfterEach
    fun tearDown(){
        mongoTemplate.remove(Query(), ProduitDocument::class.java)
    }

    @Test
    fun `quand j'appelle mon service pour rechercher un produit, il me renvoie le produit correspondant a la recherche `(){
        // GIVEN
        val produitARecuperer = ProduitFixture.produit
        val pageable = PageRequest.of(0, 1)
        val critere = produitARecuperer.nom.slice(IntRange(1, 3))
        // WHEN
        val produitRecupere = rechercherProduitRepository(pageable, critere)

        // THEN
        assertThat(produitRecupere).usingRecursiveComparison().isEqualTo(PageImpl(listOf(produitARecuperer)))
    }

    @Test
    fun `quand j'appelle mon service pour rechercher un produit, il me renvoie une liste vide si le produit n'existe pas`(){
        // GIVEN
        val pageable = PageRequest.of(0, 1)
        val critere = "produitInexistant"
        // WHEN
        val produitRecupere = rechercherProduitRepository(pageable, critere)

        // THEN
        assertThat(produitRecupere).usingRecursiveComparison().isEqualTo(PageImpl(listOf<Produit>()))
    }
}