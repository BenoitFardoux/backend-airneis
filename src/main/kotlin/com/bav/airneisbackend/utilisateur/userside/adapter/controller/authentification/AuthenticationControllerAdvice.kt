package com.bav.airneisbackend.utilisateur.userside.adapter.controller.authentification

import com.bav.airneisbackend.utilisateur.serverside.exception.AdresseMailException
import com.bav.airneisbackend.utilisateur.serverside.exception.MotDePasseInvalideException
import com.bav.airneisbackend.utilisateur.serverside.exception.UtilisateurDejaExistantException
import org.springframework.http.HttpStatus
import org.springframework.http.ProblemDetail
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice


@RestControllerAdvice(assignableTypes = [AuthenticationController::class])
class AuthenticationControllerAdvice {
    @ExceptionHandler(UtilisateurDejaExistantException::class)
    @ResponseStatus(HttpStatus.CONFLICT)
    fun error409(exception: UtilisateurDejaExistantException) : ProblemDetail{
        return ProblemDetail.forStatusAndDetail(HttpStatus.CONFLICT, exception.message)
    }

    @ExceptionHandler(AdresseMailException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun error400(exception: AdresseMailException) : ProblemDetail{
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, exception.message)
    }

    @ExceptionHandler(MotDePasseInvalideException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun error400(exception: MotDePasseInvalideException) : ProblemDetail{
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, exception.message)
    }
}