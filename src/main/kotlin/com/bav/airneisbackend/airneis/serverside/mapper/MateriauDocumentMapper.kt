package com.bav.airneisbackend.airneis.serverside.mapper

import com.bav.airneisbackend.airneis.serverside.dto.MateriauDocument
import com.bav.airneisbackend.airneis.serverside.dto.ReferentielDeMateriauDocument
import org.bson.types.ObjectId
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

object MateriauDocumentMapper {
    private fun ReferentielDeMateriauDocument.toMateriauDocument() = MateriauDocument(
        materiauId = id,
        name = name
    )

    fun toMateriauDocument(referentielDeMateriauDocument: List<ReferentielDeMateriauDocument>) : List<MateriauDocument>
    = referentielDeMateriauDocument.map { it.toMateriauDocument() }
}