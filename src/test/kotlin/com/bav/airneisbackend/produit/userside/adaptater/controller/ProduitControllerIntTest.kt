package com.bav.airneisbackend.produit.userside.adaptater.controller

import com.bav.airneisbackend.produit.domain.exception.AucunProduitTrouveException
import com.bav.airneisbackend.produit.domain.exception.ProduitInvalideException
import com.bav.airneisbackend.produit.domain.usecase.PersisterProduit
import com.bav.airneisbackend.produit.domain.usecase.RecupererProduits
import com.bav.airneisbackend.produit.domain.usecase.RecupererUnProduit
import com.bav.airneisbackend.produit.domain.usecase.SupprimerProduit
import com.bav.airneisbackend.produit.fixture.ProduitFixture
import com.bav.airneisbackend.produit.userside.mapper.ProduitMapper
import com.bav.airneisbackend.utils.JwtService
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.context.annotation.Import
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import org.springframework.http.MediaType
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.delete
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.post

@WebMvcTest(ProduitController::class, excludeAutoConfiguration = [SecurityAutoConfiguration::class])
@ExtendWith(MockitoExtension::class)
@Import(ProduitControllerAdvice::class)
class ProduitControllerIntTest {
    @MockBean
    private lateinit var JwtService : JwtService

    @MockBean
    private lateinit var UserDetailsService : UserDetailsService

    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockBean
    private lateinit var recupererProduits: RecupererProduits

    @MockBean
    private lateinit var recupererUnProduit: RecupererUnProduit

    @MockBean
    private lateinit var persisterProduit: PersisterProduit

    @MockBean
    private lateinit var supprimerProduit: SupprimerProduit

    @Test
    fun `recupererProduits should return all products`() {
        // Given
        val mockPageDeProduits = PageImpl(listOf(ProduitFixture.produit))
        val pageable = PageRequest.of(0, 10)
        `when`(recupererProduits(pageable,null)).thenReturn(mockPageDeProduits)
        // When
        // Then

        mockMvc.get("/airneis/produits") {
            contentType = MediaType.APPLICATION_JSON
            accept = MediaType.APPLICATION_JSON

        }.andExpect {
            status { isOk() }
            content { contentType(MediaType.APPLICATION_JSON) }

        }
    }

    @Test
    fun `la route get devrait renvoyer un statut 200 lorsqu'on lui donne un id correct et existant`() {
        // Given
        val id = "123456"
        `when`(recupererUnProduit(id)).thenReturn(ProduitFixture.produit)
        // When
        // Then
        mockMvc.get("/airneis/produits/$id") {
            contentType = MediaType.APPLICATION_JSON
            accept = MediaType.APPLICATION_JSON

        }.andExpect {
            status { isOk() }
            content { contentType(MediaType.APPLICATION_JSON) }
        }
    }

    @Test
    fun `la route get devrait renvoyer un statut 404 lorsqu'on lui donne un id non existant`() {
        // Given
        val id = "123457"
        `when`(recupererUnProduit(id)).thenThrow(AucunProduitTrouveException("Le produit n'existe pas"))
        // When
        // Then
        mockMvc.get("/airneis/produits/$id") {
            contentType = MediaType.APPLICATION_JSON
            accept = MediaType.APPLICATION_JSON

        }.andExpect {
            status { isNotFound() }
            content { contentType(MediaType.APPLICATION_JSON) }
        }
    }

    @Test
    fun `la route post devrait renvoyer une 201 si la requête est correcte `() {
        // Given
        val produitPourRequetePost = ProduitFixture.produitPourRequetePost
        val produit = ProduitMapper.creerProduitRestRessourceToProduit(produitPourRequetePost)
        `when`(persisterProduit(produit)).thenReturn(produit)

        // When
        // Then
        mockMvc.post("/airneis/produits") {
            contentType = MediaType.APPLICATION_JSON
            accept = MediaType.APPLICATION_JSON
            content = jacksonObjectMapper().writeValueAsString(produitPourRequetePost)

        }.andExpect {
            status { isCreated() }
            content { contentType(MediaType.APPLICATION_JSON) }

        }
    }

    @Test
    fun `la route post devrait revoyer une erreur 400 si la requête est incorrecte`() {
        // Given
        val produitPourRequetePost = ProduitFixture.produitPourRequetePost.copy(nom = "")
        val produit = ProduitMapper.creerProduitRestRessourceToProduit(produitPourRequetePost)
        val champs = listOf("Nom")
        `when`(persisterProduit(produit)).thenThrow(ProduitInvalideException("Le nom du produit est invalide", champs ))
        // When
        // Then
        mockMvc.post("/airneis/produits") {
            contentType = MediaType.APPLICATION_JSON
            accept = MediaType.APPLICATION_JSON
            content = jacksonObjectMapper().writeValueAsString(produitPourRequetePost)
        }.andExpect {
            status { isBadRequest() }
            content { contentType(MediaType.APPLICATION_JSON) }

        }
    }

    @Test
    fun `la route delete devrait renvoyer un statut 200 lorsqu'on lui donne un id correct et existant`() {
        // Given
        val id = "123456"
        `when`(supprimerProduit(id)).thenReturn(ProduitFixture.produit)
        // When
        // Then
        mockMvc.delete("/airneis/produits/$id") {
            contentType = MediaType.APPLICATION_JSON
            accept = MediaType.APPLICATION_JSON

        }.andExpect {
            status { isOk() }
            content { contentType(MediaType.APPLICATION_JSON) }
        }
    }

}