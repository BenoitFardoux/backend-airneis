package com.bav.airneisbackend.utilisateur.domain.usecase

import com.bav.airneisbackend.utilisateur.domain.port.serverside.PourRecupererUtilisateurParMailServerSidePort
import com.bav.airneisbackend.utilisateur.fixture.UtilisateurFixture
import com.bav.airneisbackend.utilisateur.serverside.exception.AdresseMailException
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension


@ExtendWith(MockitoExtension::class)
class RecupererUtilisateurParMailTest{
    @Mock
    lateinit var pourRecupererUtilisateurParMailServerSidePort: PourRecupererUtilisateurParMailServerSidePort

    @Test
    fun `Lorsque j'apelle ma fonction recupererUtilisateurParMail je ne rencontre pas d'erreur`() {
        //GIVEN
        val adresseMail = UtilisateurFixture.adresseMail
        `when`(pourRecupererUtilisateurParMailServerSidePort(adresseMail)).thenReturn(UtilisateurFixture.utilisateur)

        // WHEN THEN
        assertDoesNotThrow("recupererUtilisateurParMail ne devrait pas lancer d'exception") { pourRecupererUtilisateurParMailServerSidePort(adresseMail) }

    }

    @Test
    fun `Lorsque j'apelle ma fonction recupererUtilisateurParMail avec une adresse mail invalide je rencontre une exception`() {
        //GIVEN
        val adresseMail = UtilisateurFixture.adresseMailInvalide
        `when`(pourRecupererUtilisateurParMailServerSidePort(adresseMail)).thenThrow(AdresseMailException::class.java)
        // WHEN THEN
        assertThrows<AdresseMailException>("recupererUtilisateurParMail devrait lancer une exception") { pourRecupererUtilisateurParMailServerSidePort(adresseMail)}

    }
}