package com.bav.airneisbackend.Produit.serverside.adapter.repository

import com.bav.airneisbackend.Produit.fixture.ProduitFixture
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import org.springframework.test.context.TestPropertySource
import org.junit.jupiter.api.assertThrows


@SpringBootTest
@TestPropertySource("classpath:application-test.properties")
class PourRechercherProduitRepositoryTest{
    @Autowired
    private lateinit var rechercherProduitRepository: PourRechercherProduitRepository



    @Test
    fun `quand j'appelle mon service pour rechercher un produit, il me renvoie une erreur notYetImplemented `(){
        // GIVEN
        val produitARecuperer = ProduitFixture.produit
        val pageDeProduitARecuperer = PageImpl(listOf(produitARecuperer))
        val pageable = PageRequest.of(0, 1)
        val critere = "tab"
        // WHEN

        // THEN

        assertThrows<NotImplementedError>{rechercherProduitRepository(pageable,critere)}
    }
}