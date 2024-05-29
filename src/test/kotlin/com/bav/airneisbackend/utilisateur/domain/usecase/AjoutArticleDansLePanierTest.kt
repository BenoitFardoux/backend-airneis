package com.bav.airneisbackend.utilisateur.domain.usecase

import com.bav.airneisbackend.produit.domain.exception.ProduitInvalideException
import com.bav.airneisbackend.utilisateur.domain.port.serverside.AjouterArticleDansPanierUtilisateurServerSidePort
import com.bav.airneisbackend.utilisateur.domain.port.serverside.ConnexionUtilisateurServerSidePort
import com.bav.airneisbackend.utilisateur.fixture.UtilisateurFixture
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension


@ExtendWith(MockitoExtension::class)
class AjoutArticleDansLePanierTest{
    @Mock
    lateinit var AjouterArticleDansPanierUtilisateurServerSidePort: AjouterArticleDansPanierUtilisateurServerSidePort

    @Test
    fun `Lorsque j'apelle ma fonction ajouterArticleDansPanier je ne rencontre pas d'erreur`() {
        //GIVEN
        val idArticle = UtilisateurFixture.produit.id
        `when`(AjouterArticleDansPanierUtilisateurServerSidePort(idArticle)).thenReturn(UtilisateurFixture.utilisateur)

        // WHEN THEN
        assertDoesNotThrow("ajouterArticleDansPanier ne devrait pas lancer d'exception") { AjouterArticleDansPanierUtilisateurServerSidePort(idArticle) }
    }

    @Test
    fun `Lorsque j'apelle ma fonction ajouterArticleDansPanier avec un idArticle invalide je rencontre une exception`() {
        //GIVEN
        val idArticle = UtilisateurFixture.produit.id
        `when`(AjouterArticleDansPanierUtilisateurServerSidePort(idArticle)).thenThrow(ProduitInvalideException::class.java)
        // WHEN THEN
        assertThrows<ProduitInvalideException>("ajouterArticleDansPanier devrait lancer une exception") { AjouterArticleDansPanierUtilisateurServerSidePort(idArticle)}
    }
}