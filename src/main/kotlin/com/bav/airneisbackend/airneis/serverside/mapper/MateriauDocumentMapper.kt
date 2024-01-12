package com.bav.airneisbackend.airneis.serverside.mapper

import com.bav.airneisbackend.airneis.serverside.dto.MateriauDocument
import com.bav.airneisbackend.airneis.serverside.dto.ReferentielDeMateriauDocument

object MateriauDocumentMapper {
    private fun ReferentielDeMateriauDocument.toMateriauDocument() = MateriauDocument(
        id = id,
        name = name
    )

    fun toMateriauDocument(referentielDeMateriauDocument: List<ReferentielDeMateriauDocument>) : List<MateriauDocument>
    = referentielDeMateriauDocument.map { it.toMateriauDocument() }
}