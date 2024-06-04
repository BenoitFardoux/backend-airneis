package com.bav.airneisbackend.utilisateur.userside.adapter.controller.adresse.documentation

import com.bav.airneisbackend.utilisateur.domain.model.Adresse
import com.bav.airneisbackend.utilisateur.userside.restressource.UtilisateurRestRessource
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.responses.ApiResponse

interface AdresseControllerDocumentation {
    @Operation(
        summary = "Modifie les adresses de l'utilisateur actuel",
        description = "Modifie les adresses de l'utilisateur actuel"
    )
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200",
                description = "Les adresses de l'utilisateur ont été modifiées"
            ),
            ApiResponse(
                responseCode = "404",
                description = "Aucune adresse n'a été trouvée"
            )
        ]
    )
    fun modifierAdresses(adresses : List<Adresse>) : UtilisateurRestRessource
}