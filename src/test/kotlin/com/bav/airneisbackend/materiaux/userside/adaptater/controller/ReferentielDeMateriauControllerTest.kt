package com.bav.airneisbackend.materiaux.userside.adaptater.controller

import com.bav.airneisbackend.materiaux.domain.exception.MateriauNonTrouveException
import com.bav.airneisbackend.materiaux.domain.usecase.PersisterUnMateriau
import com.bav.airneisbackend.materiaux.domain.usecase.RecupererMateriaux
import com.bav.airneisbackend.materiaux.domain.usecase.RecupererUnMateriau
import com.bav.airneisbackend.materiaux.fixture.MateriauFixture
import com.bav.airneisbackend.materiaux.userside.mapper.MateriauMapper
import com.bav.airneisbackend.produit.userside.adaptater.controller.ProduitControllerAdvice
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
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.post


@WebMvcTest(ReferentielDeMateriauController::class, excludeAutoConfiguration = [SecurityAutoConfiguration::class])
@ExtendWith(MockitoExtension::class)
@Import(MateriauControllerAdvice::class)

class ReferentielDeMateriauControllerTest {
    @Autowired
    private lateinit var mockMvc: MockMvc
    @MockBean
    private lateinit var JwtService : JwtService

    @MockBean
    private lateinit var UserDetailsService : UserDetailsService

    @MockBean
    private lateinit var recupererMateriaux: RecupererMateriaux

    @MockBean
    private lateinit var persisterMateriau: PersisterUnMateriau

    @MockBean
    private lateinit var recupererMateriauxParId: RecupererUnMateriau

    @Test
    fun `lorsque j'utilise recupererMateriauParId avec un id valide, alors je dois avoir un status 200`() {
        // Given
        val materiau = MateriauFixture.materiau
        `when`(recupererMateriauxParId(materiau.id)).thenReturn(materiau)

        // When
        // Then
        mockMvc.get("/airneis/materiau/${materiau.id}") {
            contentType = MediaType.APPLICATION_JSON
            accept = MediaType.APPLICATION_JSON
        }.andExpect {
            status { isOk() }
            content { contentType(MediaType.APPLICATION_JSON) }
        }
    }

    @Test
    fun `lorsque j'utilise recupererMateriauParId avec un id invalide, alors je dois avoir un status 404`() {
        // Given
        val id = "123456"
        `when`(recupererMateriauxParId(id)).thenThrow(MateriauNonTrouveException::class.java)

        // When
        // Then
        mockMvc.get("/airneis/materiau/$id") {
            contentType = MediaType.APPLICATION_JSON
            accept = MediaType.APPLICATION_JSON
        }.andExpect {
            status { isNotFound() }
        }
    }


    @Test
    fun `Lorsque je fait un appel a la route get sans critere de recherche je récupère tous les matériaux`() {
        // Given
        val mockPageDeMateriaux = PageImpl(listOf(MateriauFixture.materiau))
        val pageable = PageRequest.of(0, 10)
        `when`(recupererMateriaux(pageable,null)).thenReturn(mockPageDeMateriaux)

        // When
        // Then
        mockMvc.get("/airneis/materiau") {
            contentType = MediaType.APPLICATION_JSON
            accept = MediaType.APPLICATION_JSON
        }.andExpect {
            status { isOk() }
            content { contentType(MediaType.APPLICATION_JSON) }
        }
    }

    // ne fonctionne pas a voir comment gérer le truc
    @Test
    fun `quand je fait une requete get et qu'il n'y a aucun materiau, alors je dois avoir un status 404`() {
        // Given
        val pageable = PageRequest.of(0, 10)
        `when`(recupererMateriaux(pageable,null)).thenThrow(MateriauNonTrouveException::class.java
        )

        // When
        // Then
        mockMvc.get("/airneis/materiau") {
            contentType = MediaType.APPLICATION_JSON
            accept = MediaType.APPLICATION_JSON
        }.andExpect {
            status { isNotFound() }
        }
    }


    @Test
    fun `Lorsque je fait une requete post pour persister un materiau, alors je dois avoir un status 201`() {
        // Given
        val materiauPourRequetePost = MateriauFixture.materiauPourRequetePost
        val materiau = MateriauMapper.pourCreerMateriauRestRessourceToMateriau(materiauPourRequetePost)
        `when`(persisterMateriau(materiau)).thenReturn(materiau)

        // When
        // Then
        mockMvc.post("/airneis/materiau") {
            contentType = MediaType.APPLICATION_JSON
            accept = MediaType.APPLICATION_JSON
            content = jacksonObjectMapper().writeValueAsString(materiauPourRequetePost)
        }.andExpect {
            status { isCreated() }
            content { contentType(MediaType.APPLICATION_JSON) }
        }
    }


    @Test
    fun `Lorque je fait une requete post mais qu'il manque des éléments dans le body, alors je dois avoir un status 400`() {
        // Given
        val materiauPourRequetePost = MateriauFixture.materiauPourRequetePost.copy(nom = "")

        // When
        // Then
        mockMvc.post("/airneis/materiau") {
            contentType = MediaType.APPLICATION_JSON
            accept = MediaType.APPLICATION_JSON
            content = jacksonObjectMapper().writeValueAsString(materiauPourRequetePost)
        }.andExpect {
            status { isBadRequest() }
        }
    }
}
