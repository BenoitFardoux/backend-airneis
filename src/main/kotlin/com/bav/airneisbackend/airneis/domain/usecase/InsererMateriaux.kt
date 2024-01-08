package com.bav.airneisbackend.airneis.domain.usecase

import com.bav.airneisbackend.airneis.domain.port.serverside.PourInsererMateriauxServerSidePort
import org.springframework.stereotype.Component


@Component
class InsererMateriaux(
    private val pourInsererMateriauxServerSidePort: PourInsererMateriauxServerSidePort
){
    operator fun invoke() : Int = pourInsererMateriauxServerSidePort.insererMateriaux()
}