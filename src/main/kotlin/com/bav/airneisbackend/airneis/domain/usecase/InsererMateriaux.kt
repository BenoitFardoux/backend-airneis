package com.bav.airneisbackend.airneis.domain.usecase

import com.bav.airneisbackend.airneis.domain.port.serverside.PourInsererMateriauxDepuisReferentielServerSidePort
import org.springframework.stereotype.Component


@Component
class InsererMateriaux(
    private val pourInsererMateriauxDepuisReferentielServerSidePort: PourInsererMateriauxDepuisReferentielServerSidePort
){
    operator fun invoke() : Int = pourInsererMateriauxDepuisReferentielServerSidePort.insererMateriaux()
}