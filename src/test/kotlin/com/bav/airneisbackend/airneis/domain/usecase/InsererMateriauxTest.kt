package com.bav.airneisbackend.airneis.domain.usecase

import com.bav.airneisbackend.airneis.domain.port.serverside.PourInsererMateriauxDepuisReferentielServerSidePort
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)

class InsererMateriauxTest {
    @Mock
    lateinit var pourInsererMateriauxDepuisReferentielServerSidePort: PourInsererMateriauxDepuisReferentielServerSidePort

    @Test
    fun `Lorsque j'appelle ma fonction je ne rencontre pas d'erreur`() {
        //GIVEN
        val insererMateriaux = InsererMateriaux(pourInsererMateriauxDepuisReferentielServerSidePort)
        // WHEN THEN
        assertDoesNotThrow("insererMateriaux ne devrait pas lancer d'exception") { insererMateriaux() }

    }

}