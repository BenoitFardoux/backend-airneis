package com.bav.airneisbackend.utilisateur.userside.adapter.controller.adresse

import com.bav.airneisbackend.utilisateur.domain.model.Adresse
import com.bav.airneisbackend.utilisateur.domain.usecase.adresse.ModifierAdresses
import com.bav.airneisbackend.utilisateur.userside.adapter.controller.adresse.documentation.AdresseControllerDocumentation
import com.bav.airneisbackend.utilisateur.userside.mapper.UtilisateurMapper.toUtilisateurRestRessource
import com.bav.airneisbackend.utilisateur.userside.restressource.UtilisateurRestRessource
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController



@SecurityRequirement(name = "Bearer Authentication")
@RestController("/utilisateur/adresse")
class AdresseController(val modifierLesAdresses: ModifierAdresses) : AdresseControllerDocumentation {
    @PostMapping("/modifier")
    override fun modifierAdresses(@RequestBody adresses: List<Adresse>): UtilisateurRestRessource =
         modifierLesAdresses(adresses).toUtilisateurRestRessource()


}