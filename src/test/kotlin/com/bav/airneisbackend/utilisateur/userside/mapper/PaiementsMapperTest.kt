package com.bav.airneisbackend.utilisateur.userside.mapper

import com.bav.airneisbackend.utilisateur.fixture.UtilisateurFixture
import com.bav.airneisbackend.utilisateur.userside.mapper.PaiementsMapper.toPaiement
import com.bav.airneisbackend.utilisateur.userside.restressource.MoyenDePaiementUtilisateursRestRessource
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class PaiementsMapperTest{
    @Test
    fun `should map MoyenDePaiementUtilisateursRestRessource to MoyenDePaiement`(){
        // Given
        val moyenDePaiementUtilisateursRestRessource = UtilisateurFixture.MoyenDePaiementUtilisateursRestRessource
        val moyenDePaiementAttendu = UtilisateurFixture.paiements
        // When
        val moyenDePaiement = moyenDePaiementUtilisateursRestRessource.toPaiement()
        // Then
        assertThat(moyenDePaiement).usingRecursiveComparison().isEqualTo(moyenDePaiementAttendu)
    }
}