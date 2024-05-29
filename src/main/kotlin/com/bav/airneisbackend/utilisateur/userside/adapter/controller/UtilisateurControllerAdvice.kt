package com.bav.airneisbackend.utilisateur.userside.adapter.controller

import com.bav.airneisbackend.utilisateur.serverside.exception.ProduitInnexistantException
import org.springframework.http.HttpStatus
import org.springframework.http.ProblemDetail
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice


@RestControllerAdvice(assignableTypes = [UtilisateurController::class])

class UtilisateurControllerAdvice {
    @ExceptionHandler(ProduitInnexistantException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun produitInnexistant(exception: ProduitInnexistantException) : ProblemDetail{
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, exception.message)
    }


}