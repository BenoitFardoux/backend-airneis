package com.bav.airneisbackend.Materiaux.serverside.mapper

import com.bav.airneisbackend.Materiaux.serverside.dto.MateriauDocument
import com.bav.airneisbackend.Materiaux.serverside.dto.ReferentielDeMateriauDocument

object MateriauDocumentMapper {
    private fun ReferentielDeMateriauDocument.toMateriauDocument() = MateriauDocument(
        materiauId = id,
        name = name
    )

    fun toMateriauDocument(referentielDeMateriauDocument: List<ReferentielDeMateriauDocument>) : List<MateriauDocument>
    = referentielDeMateriauDocument.map { it.toMateriauDocument() }
}