package com.bav.airneisbackend.Materiaux.serverside.mapper

import com.bav.airneisbackend.Materiaux.fixture.MateriauFixture
import com.bav.airneisbackend.Materiaux.serverside.mapper.MateriauMapper.toMateriau
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MateriauMapperTest{
    @Test
    fun `Lorsque je mappe un objet MateriauDocument en materiau, le materiau mappé contient les donnée du materiauDocument`(){
        // GIVEN
        val materiauDocument = MateriauFixture.materiauDocument
        val materiauAttendu = MateriauFixture.materiau
        // WHEN
        val materiau = materiauDocument.toMateriau()
        // THEN
        assertThat(materiau).usingRecursiveComparison().ignoringFields("id").isEqualTo(materiauAttendu)
    }
}
