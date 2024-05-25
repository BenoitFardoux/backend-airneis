package com.bav.airneisbackend.categorie.userside.adaptater.controller

import com.bav.airneisbackend.categorie.CategorieFixture
import com.bav.airneisbackend.categorie.domain.exception.CategorieInvalideException
import com.bav.airneisbackend.categorie.domain.usecase.PersisterCategorie
import com.bav.airneisbackend.categorie.domain.usecase.RecupererCategorie
import com.bav.airneisbackend.categorie.domain.usecase.RecupererCategories
import com.bav.airneisbackend.categorie.userside.mapper.CategorieMapper.toCategorie
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
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.post


@WebMvcTest(CategorieController::class, excludeAutoConfiguration = [SecurityAutoConfiguration::class])
@ExtendWith(MockitoExtension::class)
@Import(CategorieControllerAdvice::class)
class CategorieControllerTest {
    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockBean
    private lateinit var persisterCategorie: PersisterCategorie

    @MockBean
    private lateinit var recupererCategories: RecupererCategories

    @MockBean
    private lateinit var recupererCategorie: RecupererCategorie

    @Test
    fun `lorsque je fait une requete post pour persister une categorie, alors je dois avoir un status 201`() {
        // GIVEN
        val pourCreerCategorieRestRessource = CategorieFixture.pourCreerCategorieRestRessource
        val categorie = pourCreerCategorieRestRessource.toCategorie()
        `when`(persisterCategorie(categorie)).thenReturn(categorie)
        // WHEN
        // THEN
        mockMvc.post("/airneis/categories") {
            contentType = MediaType.APPLICATION_JSON
            accept = MediaType.APPLICATION_JSON
            content = jacksonObjectMapper().writeValueAsString(pourCreerCategorieRestRessource)
        }.andExpect {
            status { isCreated() }
            content { contentType(MediaType.APPLICATION_JSON) }
        }
    }

    @Test
    fun `Lorque je fait une requete post mais qu'il manque des éléments dans le body, alors je dois avoir un status 400`() {
        // GIVEN
        val pourCreerCategorieRestRessource = CategorieFixture.pourCreerCategorieRestRessource.copy(nom = "")
        val categorie = pourCreerCategorieRestRessource.toCategorie()
        `when`(persisterCategorie(categorie)).thenThrow(CategorieInvalideException("Le nom de la categorie est invalide", listOf("nom")))
        // WHEN
        // THEN
        mockMvc.post("/airneis/categories") {
            contentType = MediaType.APPLICATION_JSON
            accept = MediaType.APPLICATION_JSON
            content = jacksonObjectMapper().writeValueAsString(pourCreerCategorieRestRessource)
        }.andExpect {
            status { isBadRequest() }
            content { contentType(MediaType.APPLICATION_JSON) }
        }
    }

    @Test
    fun `lorsque je fait une requete get pour recuperer les categories, alors je dois avoir un status 200 et les categories`() {
        // GIVEN
        val pageable = PageRequest.of(0, 10)
        val categories = PageImpl(listOf(CategorieFixture.uneCategorie))

        `when`(recupererCategories(pageable)).thenReturn(categories)

        // WHEN
        // THEN
        mockMvc.get("/airneis/categories") {
            contentType = MediaType.APPLICATION_JSON
            accept = MediaType.APPLICATION_JSON
        }.andExpect {
            status { isOk() }
            content { contentType(MediaType.APPLICATION_JSON) }
        }
    }

    @Test
    fun `lorsque je fait une requete get pour recuperer une categorie par id, alors je dois avoir un status 200 et la categorie`() {
        // GIVEN
        val categorie = CategorieFixture.uneCategorie

        `when`(recupererCategorie(categorie.id)).thenReturn(categorie)

        // WHEN
        // THEN
        mockMvc.get("/airneis/categories/${categorie.id}") {
            contentType = MediaType.APPLICATION_JSON
            accept = MediaType.APPLICATION_JSON
        }.andExpect {
            status { isOk() }
            content { contentType(MediaType.APPLICATION_JSON) }
        }
    }
}