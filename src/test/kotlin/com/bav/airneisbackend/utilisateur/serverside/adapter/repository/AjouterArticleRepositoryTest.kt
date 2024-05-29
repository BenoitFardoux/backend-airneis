package com.bav.airneisbackend.utilisateur.serverside.adapter.repository

import com.bav.airneisbackend.produit.serverside.adapter.mongodb.repository.MongoDbProduitRepository
import com.bav.airneisbackend.utilisateur.serverside.adapter.mongodb.repository.MongoDbUtilisateurRepository
import com.bav.airneisbackend.utilisateur.serverside.exception.ProduitInnexistantException
import com.bav.airneisbackend.utilisateur.fixture.UtilisateurFixture
import com.bav.airneisbackend.utilisateur.serverside.dto.UtilisateurDocument
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentCaptor
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContext
import org.springframework.security.core.context.SecurityContextHolder

@ExtendWith(MockitoExtension::class)
class AjouterArticleRepositoryTest {

    @Mock
    private lateinit var produitRepository: MongoDbProduitRepository

    @Mock
    private lateinit var utilisateurRepository: MongoDbUtilisateurRepository

    @Mock
    private lateinit var authentication: Authentication

    @Mock
    private lateinit var securityContext: SecurityContext

    @InjectMocks
    private lateinit var ajouterArticleRepository: AjouterArticleRepository

    @BeforeEach
    fun setUp() {
        SecurityContextHolder.setContext(securityContext)
    }

    @Test
    fun `test ajouter article existant au panier`() {
        // GIVEN
        val idArticle = UtilisateurFixture.produit.id
        `when`(produitRepository.existsById(idArticle)).thenReturn(true)

        val utilisateur = UtilisateurFixture.utilisateurDocument.copy(panierActuel = UtilisateurFixture.panier.copy(produits = mutableListOf()))
        `when`(authentication.principal).thenReturn(utilisateur)
        `when`(securityContext.authentication).thenReturn(authentication)
        `when`(utilisateurRepository.save(utilisateur)).thenReturn(utilisateur)

        // WHEN
        ajouterArticleRepository.invoke(idArticle)

        // THEN
        val argumentCaptor = ArgumentCaptor.forClass(UtilisateurDocument::class.java)
        verify(utilisateurRepository).save(argumentCaptor.capture())

        val savedUtilisateur = argumentCaptor.value
        assertEquals(1, savedUtilisateur.panierActuel.produits.size)
        assertEquals(idArticle, savedUtilisateur.panierActuel.produits.first().id)
        assertEquals(1, savedUtilisateur.panierActuel.produits.first().quantite)
    }

    @Test
    fun `test ajouter article inexistant au panier`() {
        // GIVEN
        val idArticle = UtilisateurFixture.produit.id
        `when`(produitRepository.existsById(idArticle)).thenReturn(false)

        // WHEN & THEN
        assertThrows(ProduitInnexistantException::class.java) {
            ajouterArticleRepository.invoke(idArticle)
        }
    }

    @Test
    fun `test ajouter article deja present dans le panier`() {
        // GIVEN
        val idArticle = UtilisateurFixture.produit.id
        `when`(produitRepository.existsById(idArticle)).thenReturn(true)

        val produit = UtilisateurFixture.produit
        val utilisateur = UtilisateurFixture.utilisateurDocument.copy(panierActuel = UtilisateurFixture.panier.copy(produits = mutableListOf(produit)))
        `when`(authentication.principal).thenReturn(utilisateur)
        `when`(securityContext.authentication).thenReturn(authentication)
        `when`(utilisateurRepository.save(utilisateur)).thenReturn(utilisateur)

        // WHEN
        ajouterArticleRepository.invoke(idArticle)

        // THEN
        val argumentCaptor = ArgumentCaptor.forClass(UtilisateurDocument::class.java)
        verify(utilisateurRepository).save(argumentCaptor.capture())

        val savedUtilisateur = argumentCaptor.value
        assertEquals(1, savedUtilisateur.panierActuel.produits.size)
        assertEquals(idArticle, savedUtilisateur.panierActuel.produits.first().id)
        assertEquals(2, savedUtilisateur.panierActuel.produits.first().quantite)
    }
}
