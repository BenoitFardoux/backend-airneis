package com.bav.airneisbackend.airneis.serverside.mapper

import com.bav.airneisbackend.airneis.fixture.MateriauFixture
import com.bav.airneisbackend.airneis.serverside.mapper.MateriauMapper.toMateriau
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat



class MateriauMapperTest{
    @Test
    fun `Lorsque je mappe un materiauDocument en materiau, l'objet materiau contient les informations du document`(){
        // GIVEN
        val materiauDocument = MateriauFixture.materiauDocument

        val materiauMappe = MateriauFixture.materiau
        // WHEN
        val resultatMapping = materiauDocument.toMateriau()

        // THEN
        assertThat(resultatMapping).isEqualTo(materiauMappe)
    }
}