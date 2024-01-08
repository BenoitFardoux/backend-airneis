package com.bav.airneisbackend.airneis.domain.usecase

import com.bav.airneisbackend.airneis.domain.port.serverside.PourRechercherMateriauParMotCleServerSidePort
import com.bav.airneisbackend.airneis.domain.port.serverside.PourRecupererMateriauxServersidePort
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.data.domain.PageRequest


@ExtendWith(MockitoExtension::class)
class RecupererMateriauxTest{
    @Mock
    lateinit var pourRecupererMateriauxServersidePort: PourRecupererMateriauxServersidePort

    @Mock
    lateinit var pourRecupererMateriauParMotCleServerSidePort: PourRechercherMateriauParMotCleServerSidePort

    @Test
    fun `Lorsque j'apelle ma fonction je ne rencontre pas d'erreur`() {
        //GIVEN
        val recupererMateriaux = RecupererMateriaux(pourRecupererMateriauxServersidePort,pourRecupererMateriauParMotCleServerSidePort)
        val critereDeRecherche = ""
        val pageable = PageRequest.of(1,1)
        // WHEN THEN
        assertDoesNotThrow("insererMateriaux ne devrait pas lancer d'exception") { recupererMateriaux(pageable,critereDeRecherche) }

    }
}