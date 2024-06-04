package com.bav.airneisbackend.utilisateur.domain.usecase

import com.bav.airneisbackend.utilisateur.domain.port.serverside.PourSupprimerArticleDansPanierServerSidePort
import com.bav.airneisbackend.utilisateur.domain.usecase.panier.SupprimerArticleDansPanier
import com.bav.airneisbackend.utilisateur.fixture.UtilisateurFixture
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension


@ExtendWith(MockitoExtension::class)
class SupprimerArticleDansPanierTest{
    @Mock
    private lateinit var  supprimerArticleDansPanierServerSidePort : PourSupprimerArticleDansPanierServerSidePort

    @Test
    fun `Lorsque j'apelle ma fonction supprimerArticleDansPanier je ne rencontre pas d'erreur`() {
        //GIVEN
        val idArticle = UtilisateurFixture.produit.id
        `when`(supprimerArticleDansPanierServerSidePort(idArticle)).thenReturn(UtilisateurFixture.utilisateur.panierActuel.produits[0])

        // WHEN THEN
        assertDoesNotThrow("ajouterArticleDansPanier ne devrait pas lancer d'exception") { SupprimerArticleDansPanier(supprimerArticleDansPanierServerSidePort).invoke(idArticle) }
    }
}