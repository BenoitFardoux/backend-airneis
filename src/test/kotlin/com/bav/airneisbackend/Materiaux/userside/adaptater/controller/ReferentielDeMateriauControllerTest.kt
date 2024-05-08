package com.bav.airneisbackend.Materiaux.userside.adaptater.controller

import com.bav.airneisbackend.Materiaux.domain.exception.MateriauNonTrouveException
import com.bav.airneisbackend.Materiaux.domain.usecase.PersisterUnMateriau
import com.bav.airneisbackend.Materiaux.domain.usecase.RecupererMateriaux
import com.bav.airneisbackend.Materiaux.domain.usecase.RecupererUnMateriau
import com.bav.airneisbackend.Materiaux.fixture.MateriauFixture
import com.bav.airneisbackend.Materiaux.userside.mapper.MateriauMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
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


@WebMvcTest(ReferentielDeMateriauController::class, excludeAutoConfiguration = [SecurityAutoConfiguration::class])
@ExtendWith(MockitoExtension::class)
class ReferentielDeMateriauControllerTest {
    @Autowired
    private lateinit var mockMvc: MockMvc

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
    fun `recupererMateriaux should return all products`() {
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
}
