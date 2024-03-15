package com.bav.airneisbackend.produit.serverside.dto

import com.bav.airneisbackend.Materiaux.serverside.dto.MateriauDocument
import com.bav.airneisbackend.produit.domain.model.Categorie
import com.bav.airneisbackend.produit.domain.model.Materiau
import org.bson.types.ObjectId
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.MongoId


@Document("produit")
data class ProduitDocument(
    @MongoId
    val id : String?,
    val nom : String,
    val description : String,
    val prix : Double,
    val images : List<String>,
    val dimension : Dimension,
    val categorie : Categorie,
    val materiaux : List<Materiau>
)
