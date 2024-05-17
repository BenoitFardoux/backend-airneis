package com.bav.airneisbackend.categorie.domain.usecase

import com.bav.airneisbackend.categorie.CategorieFixture.Companion.uneCategorie
import com.bav.airneisbackend.categorie.domain.port.serverside.categorie.PourPersisterCategorie
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension


@ExtendWith(MockitoExtension::class)
class PersisterCategorieTest{
    @Mock
    lateinit var pourPersisterCategorie: PourPersisterCategorie

    @Test
    fun `Lorsque j'apelle ma fonction pourPersisterCategorie je ne rencontre pas d'erreur`() {
        //GIVEN
        val persisterCategorie = PersisterCategorie(pourPersisterCategorie)
        // WHEN THEN
        assertDoesNotThrow("insererCategorie ne devrait pas lancer d'exception") { persisterCategorie(uneCategorie) }
    }
}