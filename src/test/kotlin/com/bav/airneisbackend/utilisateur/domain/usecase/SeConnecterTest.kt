package com.bav.airneisbackend.utilisateur.domain.usecase

import com.bav.airneisbackend.utilisateur.domain.port.serverside.PourSeConnecterServerSidePort
import com.bav.airneisbackend.utilisateur.fixture.UserFixture.utilisateurValide
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension


@ExtendWith(MockitoExtension::class)
class SeConnecterTest{
    @Mock
    lateinit var pourSeConnecterServerSidePort : PourSeConnecterServerSidePort

    @Test
    fun `Lorsque j'apelle ma fonction seConnecter je ne rencontre pas d'erreur`() {
        //GIVEN
        val seConnecter = SeConnecter(pourSeConnecterServerSidePort)
        // WHEN THEN
        assertDoesNotThrow("seConnecter ne devrait pas lancer d'exception") { seConnecter(utilisateurValide) }
    }
}