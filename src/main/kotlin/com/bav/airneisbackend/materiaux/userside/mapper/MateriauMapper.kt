package com.bav.airneisbackend.materiaux.userside.mapper

import com.bav.airneisbackend.materiaux.domain.model.Materiau
import com.bav.airneisbackend.materiaux.userside.restressources.MateriauRestRessource
import com.bav.airneisbackend.materiaux.userside.restressources.PourCreerMateriauRestRessource
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl

object MateriauMapper {

    fun materiauToMateriauRestRessource(materiau: Materiau): MateriauRestRessource {
        with(materiau) {
            return MateriauRestRessource(
                id = id,
                nom = nom,
                type = type,
                image = image
            )
        }
    }
    fun materiauToMateriauRestRessource(materiaux: List<Materiau>): List<MateriauRestRessource> {
        return materiaux.map { materiau: Materiau ->
            with(materiau) {
                MateriauRestRessource(
                    id = id,
                    nom = nom,
                    type = type,
                    image = image
                )
            }
        }
    }

    fun mapMateriauPageToMateriauRestRessource(pageMateriau: Page<Materiau>): Page<MateriauRestRessource> {
        val mappedMateriau = materiauToMateriauRestRessource(pageMateriau.content)
        return PageImpl(mappedMateriau, pageMateriau.pageable, pageMateriau.totalElements)
    }

    fun pourCreerMateriauRestRessourceToMateriau(pourCreerMateriauRestRessource: PourCreerMateriauRestRessource): Materiau {
        with(pourCreerMateriauRestRessource) {
            return Materiau(
                nom = nom,
                type = type,
                image = image
            )
        }
    }
}