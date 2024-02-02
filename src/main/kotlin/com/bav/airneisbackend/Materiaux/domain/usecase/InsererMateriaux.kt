package com.bav.airneisbackend.Materiaux.domain.usecase

import com.bav.airneisbackend.Materiaux.domain.port.serverside.PourInsererMateriauxDepuisReferentielServerSidePort
import org.springframework.stereotype.Component


@Component
class InsererMateriaux(
    private val pourInsererMateriauxDepuisReferentielServerSidePort: PourInsererMateriauxDepuisReferentielServerSidePort
){
    operator fun invoke() : Int = pourInsererMateriauxDepuisReferentielServerSidePort.insererMateriaux()
}