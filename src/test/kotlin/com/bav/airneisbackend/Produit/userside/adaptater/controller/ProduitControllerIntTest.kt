package com.bav.airneisbackend.Produit.userside.adaptater.controller

import com.bav.airneisbackend.Produit.domain.exception.AucunProduitTrouveException
import com.bav.airneisbackend.Produit.domain.usecase.RecupererProduits
import com.bav.airneisbackend.Produit.domain.usecase.RecupererUnProduit
import com.bav.airneisbackend.Produit.fixture.ProduitFixture
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.post

@WebMvcTest(ProduitController::class, excludeAutoConfiguration = [SecurityAutoConfiguration::class])
@ExtendWith(MockitoExtension::class)
class ProduitControllerIntTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockBean
    private lateinit var recupererProduits: RecupererProduits
    @MockBean
    private lateinit var recupererUnProduit: RecupererUnProduit
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
    fun `la route post devrait renvoyer une erreur not implemented lorsqu'on lui donne un id`() {
        // Given
        // When
        // Then
        mockMvc.post("/airneis/produits/") {
            contentType = MediaType.APPLICATION_JSON
            accept = MediaType.APPLICATION_JSON

        }.andExpect {
            status { isNotImplemented() }
            content { contentType(MediaType.APPLICATION_JSON) }

        }
    }
}