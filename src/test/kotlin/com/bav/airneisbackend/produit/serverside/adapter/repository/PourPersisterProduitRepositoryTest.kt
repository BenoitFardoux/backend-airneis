package com.bav.airneisbackend.produit.serverside.adapter.repository

import com.bav.airneisbackend.Materiaux.serverside.dto.MateriauDocument
import com.bav.airneisbackend.categorie.CategorieFixture
import com.bav.airneisbackend.categorie.serverside.adapter.mongodb.repository.MongoDbCategorieRepository
import com.bav.airneisbackend.produit.fixture.MateriauFixture
import com.bav.airneisbackend.produit.fixture.ProduitFixture
import com.bav.airneisbackend.produit.serverside.adapter.mongodb.repository.MongoDbProduitRepository
import com.bav.airneisbackend.produit.serverside.dto.ProduitDocument
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.remove
import org.springframework.test.context.TestPropertySource
import kotlin.jvm.optionals.getOrNull


@SpringBootTest
@TestPropertySource("classpath:application-test.properties")

class PourPersisterProduitRepositoryTest {
    @Autowired
    private lateinit var persisterProduitRepository: PourPersisterProduitRepository

    @Autowired
    private lateinit var mongoDbProduitsRepository: MongoDbProduitRepository
    @Autowired
    private lateinit var mongoDbCategoriesRepository: MongoDbCategorieRepository

    @Autowired
    private lateinit var mongoTemplate: MongoTemplate

    @BeforeEach
    fun setUp() {
        mongoDbCategoriesRepository.insert(CategorieFixture.categorieDocument)
        mongoTemplate.insert(MateriauFixture.materiauDocument)
        mongoTemplate.insert(ProduitFixture.produitDocument)
    }

    @AfterEach
    fun tearDown() {
        mongoDbCategoriesRepository.deleteAll()
        mongoTemplate.remove(Query(), MateriauDocument::class.java)
        mongoTemplate.remove(Query(), ProduitDocument::class.java)
    }

    @Test
    fun `lorsque j'essaye de persiter un produit dans la base de donnée je récupère le produit`() {
        // GIVEN
        val produit = ProduitFixture.produit
        // WHEN
        val produitPersister = persisterProduitRepository(produit)
        // THEN
        assertThat(produitPersister.id).isNotEmpty()
        assertThat(produitPersister).usingRecursiveComparison().ignoringFields("id").isEqualTo(produit)

        mongoDbProduitsRepository.findById(produitPersister.id).get().let {
            assertThat(it).usingRecursiveComparison().isEqualTo(produitPersister)
        }
        val categorie = mongoDbCategoriesRepository.findById(CategorieFixture.categorieDocument.id).get()
        assertThat(categorie.produits.find { it.id == produitPersister.id })
    }
}


