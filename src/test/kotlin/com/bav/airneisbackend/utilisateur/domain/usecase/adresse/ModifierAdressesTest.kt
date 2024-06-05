package com.bav.airneisbackend.utilisateur.domain.usecase.adresse

import com.bav.airneisbackend.utilisateur.domain.model.Adresse
import com.bav.airneisbackend.utilisateur.domain.port.serverside.adresse.ModifierAdressesServerSidePort
import com.bav.airneisbackend.utilisateur.fixture.UtilisateurFixture
import com.bav.airneisbackend.utilisateur.serverside.exception.AdresseInvalideException
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension


@ExtendWith(MockitoExtension::class)
class ModifierAdressesTest {
    @Mock
    private lateinit var pourModifierAdressesServerSidePort: ModifierAdressesServerSidePort

    @Test
    fun `quand j'essaye de modifier les adresses et que les adresses sont valides je n'ai pas d'exception`() {
        // Given
        val adresses = mutableListOf(
            Adresse(
                codePostal = "75000",
                ville = "Paris",
                pays = "France",
                numeroDeRue = "1",
                informations = "Bâtiment A",
                telephone = "0123456789",
                prenom = "John",
                nom = "Doe",
            )
            )
        val modifierAdresses = ModifierAdresses(pourModifierAdressesServerSidePort)
        val utilisateur = UtilisateurFixture.utilisateur.copy(adresse = adresses)
        `when`(pourModifierAdressesServerSidePort(adresses)).thenReturn(utilisateur)
        // When
        // Then
        assertDoesNotThrow("modifierAdresses should not throw an exception") { modifierAdresses(adresses) }
    }

    @Test
    fun `quand j'essaye de modifier les adresses mais qu'une d'entre elle n'est pas valide un exception est lancée`() {
        // Given
        val adresses = listOf(
            Adresse(
                codePostal = "",
                ville = "Paris",
                pays = "France",
                numeroDeRue = "1",
                informations = "Bâtiment A",
                telephone = "0123456789",
                prenom = "John",
                nom = "Doe",
            )
            )
        val modifierAdresses = ModifierAdresses(pourModifierAdressesServerSidePort)
        // When
        // Then
        assertThrows<AdresseInvalideException>("modifierAdresses should throw an exception") { modifierAdresses(adresses) }
    }
}
