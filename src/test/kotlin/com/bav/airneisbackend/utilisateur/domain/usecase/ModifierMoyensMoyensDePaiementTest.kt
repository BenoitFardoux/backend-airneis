package com.bav.airneisbackend.utilisateur.domain.usecase

import com.bav.airneisbackend.utilisateur.domain.model.MoyenDePaiement
import com.bav.airneisbackend.utilisateur.domain.port.serverside.PourModifierMoyensDePaiementServerSidePort
import com.bav.airneisbackend.utilisateur.fixture.UtilisateurFixture
import com.bav.airneisbackend.utilisateur.serverside.exception.MoyenDePaiementsInvalideException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.extension.ExtendWith

import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class ModifierMoyensMoyensDePaiementTest {

    @Mock
    private lateinit var pourModifierMoyensDePaiementServerSidePort: PourModifierMoyensDePaiementServerSidePort


    @Test
    fun `Lorsque j'appelle ma fonction modifierMoyensDePaiement avec une liste vide de moyens de paiements, je ne rencontre pas d'erreur`() {
        // GIVEN
        val paiements = mutableListOf<MoyenDePaiement>()

        // WHEN

        // THEN
        assertDoesNotThrow("modifierMoyensDePaiement ne devrait pas lancer d'exception") {
            ModifierMoyensMoyensDePaiement(pourModifierMoyensDePaiementServerSidePort).invoke(paiements)
        }
    }

    @Test
    fun `Lorsque j'appelle ma fonction modifierMoyensDePaiement avec un numero de carte invalide, une exception est lancee`() {
        // GIVEN
        val paiements = listOf(UtilisateurFixture.paiements.copy(numeroCarte = "12345678901234567"))

        // WHEN THEN
        assertThrows(MoyenDePaiementsInvalideException::class.java) {
            ModifierMoyensMoyensDePaiement(pourModifierMoyensDePaiementServerSidePort).invoke(paiements)
        }
    }

    @Test
    fun `Lorsque j'appelle ma fonction modifierMoyensDePaiement avec une date d'expiration invalide, une exception est lancee`() {
        // GIVEN
        val paiements = listOf(UtilisateurFixture.paiements.copy(dateExpiration = "12/2025"))

        // WHEN THEN
        assertThrows(MoyenDePaiementsInvalideException::class.java) {
            ModifierMoyensMoyensDePaiement(pourModifierMoyensDePaiementServerSidePort).invoke(paiements)
        }
    }

    @Test
    fun `Lorsque j'appelle ma fonction modifierMoyensDePaiement avec un code de securite invalide, une exception est lancee`() {
        // GIVEN
        val paiements = listOf(UtilisateurFixture.paiements.copy(codeSecurite = "1234"))

        // WHEN THEN
        assertThrows(MoyenDePaiementsInvalideException::class.java) {
            ModifierMoyensMoyensDePaiement(pourModifierMoyensDePaiementServerSidePort).invoke(paiements)
        }
    }

    @Test
    fun `Lorsque j'appelle ma fonction modifierMoyensDePaiement avec des moyens de paiements valides, le port est appelee correctement`() {
        // GIVEN
        val paiements = listOf(UtilisateurFixture.paiements)
        val utilisateur = UtilisateurFixture.utilisateur.copy(paiements = paiements)
        `when`(pourModifierMoyensDePaiementServerSidePort(paiements)).thenReturn(utilisateur)

        // WHEN
        val resultat = ModifierMoyensMoyensDePaiement(pourModifierMoyensDePaiementServerSidePort).invoke(paiements)

        // THEN
        assertThat(utilisateur).usingRecursiveComparison().isEqualTo(resultat)
    }
}
