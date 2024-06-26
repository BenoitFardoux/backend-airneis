package com.bav.airneisbackend.materiaux.serverside.mapper

import com.bav.airneisbackend.materiaux.fixture.MateriauFixture
import com.bav.airneisbackend.materiaux.serverside.mapper.MateriauMapper.toMateriau
import com.bav.airneisbackend.materiaux.serverside.mapper.MateriauMapper.toMateriauDocument
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

    @Test
    fun `Lorsque je mappe un objet Materiau en MateriauDocument, le materiauDocument mappé contient les donnée du materiau`(){
        // GIVEN
        val materiau = MateriauFixture.materiau
        val materiauDocumentAttendu = MateriauFixture.materiauDocument
        // WHEN
        val materiauDocument = materiau.toMateriauDocument()
        // THEN
        assertThat(materiauDocument).usingRecursiveComparison().isEqualTo(materiauDocumentAttendu)
    }

    @Test
    fun `lorsque je mappe un objet Materiau avec un id vide, le materiauDocument mappé contient un id généré`(){
        // GIVEN
        val materiau = MateriauFixture.materiau.copy(id = "")
        // WHEN
        val materiauDocument = materiau.toMateriauDocument()
        // THEN
        assertThat(materiauDocument.id).isNotEmpty()
    }

    @Test
    fun `lorsque je mappe un objet Materiau avec un id null, le materiauDocument mappé contient un id`(){
        // GIVEN
        val materiau = MateriauFixture.materiauSansId
        // WHEN
        val materiauDocument = materiau.toMateriauDocument()
        // THEN
        assertThat(materiauDocument.id).isNotEmpty()
    }
}
