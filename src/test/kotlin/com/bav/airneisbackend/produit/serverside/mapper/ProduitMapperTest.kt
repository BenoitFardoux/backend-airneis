package com.bav.airneisbackend.produit.serverside.mapper


import com.bav.airneisbackend.produit.serverside.mapper.ProduitMapper.toProduit
import com.bav.airneisbackend.produit.serverside.mapper.fixture.ProduitFixture
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ProduitMapperTest{
    @Test
    fun `should map ProduitDocument to Produit`() {
        // Given
        val produitDocument = ProduitFixture.produitDocument
        val produitAttendu = ProduitFixture.produit
        // When
        val produitMappe = produitDocument.toProduit()
        // Then
        assertThat(produitMappe).usingRecursiveComparison().ignoringFields("id").isEqualTo(produitAttendu)
    }
}