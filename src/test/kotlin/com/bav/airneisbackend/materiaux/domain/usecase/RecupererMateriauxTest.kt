package com.bav.airneisbackend.materiaux.domain.usecase

import com.bav.airneisbackend.materiaux.domain.port.serverside.PourRechercherMateriau
import com.bav.airneisbackend.materiaux.domain.port.serverside.PourRecupererMateriaux
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.data.domain.PageRequest


@ExtendWith(MockitoExtension::class)
class RecupererMateriauxTest{
    @Mock
    lateinit var pourRecupererMateriaux: PourRecupererMateriaux

    @Mock
    lateinit var pourRecupererMateriauParMotCleServerSidePort: PourRechercherMateriau

    @Test
    fun `Lorsque j'apelle ma fonction pourrecuperermateriaux je ne rencontre pas d'erreur`() {
        //GIVEN
        val recupererMateriaux = RecupererMateriaux(pourRecupererMateriaux,pourRecupererMateriauParMotCleServerSidePort)
        val critereDeRecherche = ""
        val pageable = PageRequest.of(1,1)
        // WHEN THEN
        assertDoesNotThrow("insererMateriaux ne devrait pas lancer d'exception") { recupererMateriaux(pageable,critereDeRecherche) }

    }
    @Test
    fun `Lorsque j'apelle ma fonction pourrecuperermateriauxParMotCle je ne rencontre pas d'erreur`() {
        //GIVEN
        val recupererMateriaux = RecupererMateriaux(pourRecupererMateriaux,pourRecupererMateriauParMotCleServerSidePort)
        val critereDeRecherche = "bois"
        val pageable = PageRequest.of(1,1)
        // WHEN THEN
        assertDoesNotThrow("insererMateriaux ne devrait pas lancer d'exception") { recupererMateriaux(pageable,critereDeRecherche) }

    }
}