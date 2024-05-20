package com.bav.airneisbackend.materiaux.domain.exception

abstract class MateriauException(open val description: String) : RuntimeException(){
    override val message: String
        get() = description
}