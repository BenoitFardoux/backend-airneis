package com.bav.airneisbackend.Materiaux.domain.usecase


import com.bav.airneisbackend.Materiaux.domain.port.serverside.PourRecupererUnMateriau
import com.bav.airneisbackend.Materiaux.fixture.MateriauFixture
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension


@ExtendWith(MockitoExtension::class)
class RecupererUnMateriauTest {
    @Mock
    lateinit var pourRecupererUnMateriau: PourRecupererUnMateriau

    @Test
    fun `Lorsque j'apelle ma fonction pourrecupererUnMateriau je ne rencontre pas d'erreur`() {
        //GIVEN
        `when`(pourRecupererUnMateriau("1")).thenReturn(MateriauFixture.materiau)
        val recupererUnMateriau = RecupererUnMateriau(pourRecupererUnMateriau)
        val id = "1"
        // WHEN THEN
        assertDoesNotThrow("recupererUnMateriau ne devrait pas lancer d'exception") { recupererUnMateriau(id) }

    }


}