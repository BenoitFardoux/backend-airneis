package com.bav.airneisbackend.materiaux.domain.usecase

import com.bav.airneisbackend.materiaux.domain.port.serverside.PourPersisterUnMateriau
import com.bav.airneisbackend.materiaux.fixture.MateriauFixture
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension


@ExtendWith(MockitoExtension::class)
class PersisterUnMateriauTest{
    @Mock
    lateinit var pourPersisterUnMateriau: PourPersisterUnMateriau

    @Test
    fun `Lorsque j'apelle ma fonction pourPersisterUnMateriau je ne rencontre pas d'erreur`() {
        //GIVEN
        val persisterUnMateriau = PersisterUnMateriau(pourPersisterUnMateriau)
        val materiau = MateriauFixture.materiauSansId
        // WHEN THEN
        assertDoesNotThrow("insererMateriaux ne devrait pas lancer d'exception") { persisterUnMateriau(materiau) }
    }
}