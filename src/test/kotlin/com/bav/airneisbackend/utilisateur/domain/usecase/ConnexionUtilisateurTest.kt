package com.bav.airneisbackend.utilisateur.domain.usecase

import com.bav.airneisbackend.utilisateur.domain.port.serverside.ConnexionUtilisateurServerSidePort
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
class ConnexionUtilisateurTest{
    @Mock
    lateinit var pourRecupererUtilisateurParMailServerSidePort: ConnexionUtilisateurServerSidePort

    @Test
    fun `Lorsque j'apelle ma fonction recupererUtilisateurParMail je ne rencontre pas d'erreur`() {
        //GIVEN
        val adresseMail = UtilisateurFixture.adresseMail
        val motDePasse = UtilisateurFixture.motDePasse
        `when`(pourRecupererUtilisateurParMailServerSidePort(adresseMail, motDePasse)).thenReturn(UtilisateurFixture.utilisateur)

        // WHEN THEN
        assertDoesNotThrow("recupererUtilisateurParMail ne devrait pas lancer d'exception") { pourRecupererUtilisateurParMailServerSidePort(adresseMail, motDePasse) }

    }

    @Test
    fun `Lorsque j'apelle ma fonction recupererUtilisateurParMail avec une adresse mail invalide je rencontre une exception`() {
        //GIVEN
        val adresseMail = UtilisateurFixture.adresseMailInvalide
        val motDePasse = UtilisateurFixture.motDePasse
        `when`(pourRecupererUtilisateurParMailServerSidePort(adresseMail, motDePasse)).thenThrow(AdresseMailException::class.java)
        // WHEN THEN
        assertThrows<AdresseMailException>("recupererUtilisateurParMail devrait lancer une exception") { pourRecupererUtilisateurParMailServerSidePort(adresseMail, motDePasse)}

    }
}