package com.bav.airneisbackend.utilisateur.userside.adapter.controller

import com.bav.airneisbackend.utilisateur.serverside.exception.MotDePasseInvalideException
import com.bav.airneisbackend.utilisateur.serverside.exception.UtilisateurDejaExistantException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice


@RestControllerAdvice(assignableTypes = [AuthenticationController::class])
class AuthenticationControllerAdvice {
    @ExceptionHandler(UtilisateurDejaExistantException::class)
    @ResponseStatus(HttpStatus.CONFLICT)
    fun error409(exception: UtilisateurDejaExistantException) : String{
        return exception.description
    }

    @ExceptionHandler(MotDePasseInvalideException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun error400(exception: MotDePasseInvalideException) : String{
        return exception.description
    }
}