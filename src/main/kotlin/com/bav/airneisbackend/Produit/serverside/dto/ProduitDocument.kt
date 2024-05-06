package com.bav.airneisbackend.Produit.serverside.dto

import com.bav.airneisbackend.Produit.domain.model.Categorie
import com.bav.airneisbackend.Produit.domain.model.Materiau
import com.bav.airneisbackend.Produit.domain.model.Produit
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
    val dimension : Produit.Dimension,
    val categorie : Categorie,
    val materiaux : List<Materiau>
)
