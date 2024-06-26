package com.bav.airneisbackend.produit.domain.usecase

import com.bav.airneisbackend.produit.fixture.ProduitFixture
import com.bav.airneisbackend.produit.serverside.adapter.repository.PourRechercherProduitRepository
import com.bav.airneisbackend.produit.serverside.adapter.repository.PourRecupererProduitsRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest

@ExtendWith(MockitoExtension::class)
class RecupererProduitsTest{
    @Mock
    private lateinit var pourRecupererProduitsRepository: PourRecupererProduitsRepository

    @Mock
    private lateinit var pourRechercherProduitRepository: PourRechercherProduitRepository

    @Test
    fun `lorsque j'appelle le usecase 'récupérerProduits', je récupère l'ensemble des produits du référentiel`(){
        //GIVEN
        val recupererProduits = RecupererProduits(pourRecupererProduitsRepository,pourRechercherProduitRepository)
        val pageProduitAttendue = PageImpl(listOf(ProduitFixture.produit))
        val pageable = PageRequest.of(0, 10)
        Mockito.`when`(pourRecupererProduitsRepository(pageable)).thenReturn(pageProduitAttendue)

        //WHEN
        val pageProduitRecuperee = recupererProduits(pageable,"")

        //THEN
        assertThat(pageProduitRecuperee).isEqualTo(pageProduitAttendue)
    }
}