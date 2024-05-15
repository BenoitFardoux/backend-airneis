package com.bav.airneisbackend.produit.domain.usecase

import com.bav.airneisbackend.produit.domain.port.serverside.produit.PourPersisterProduit
import com.bav.airneisbackend.produit.fixture.ProduitFixture
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension


@ExtendWith(MockitoExtension::class)
class PersisterProduitTest{
    @Mock
    private lateinit var pourPersisterProduit: PourPersisterProduit

    @Test
    fun `lorsque j'apelle ma fonction pourPersisterProduit je ne rencontre pas d'erreur`(){
        //GIVEN
        val persisterProduit = PersisterProduit(pourPersisterProduit)
        val produitAPersister = ProduitFixture.produit
        // WHEN THEN
        assertDoesNotThrow("insererProduit ne devrait pas lancer d'exception") { persisterProduit(produitAPersister) }
    }
}