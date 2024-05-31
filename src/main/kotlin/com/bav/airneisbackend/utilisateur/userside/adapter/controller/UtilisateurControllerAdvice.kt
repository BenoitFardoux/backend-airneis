package com.bav.airneisbackend.utilisateur.userside.adapter.controller

import com.bav.airneisbackend.utilisateur.serverside.exception.ProduitInnexistantException
import com.bav.airneisbackend.utilisateur.serverside.exception.ProduitIntrouvableDansPanierException
import com.bav.airneisbackend.utilisateur.serverside.exception.ProduitsIntrouvableException
import com.bav.airneisbackend.utilisateur.serverside.exception.UtilisateurException
import org.springframework.http.HttpStatus
import org.springframework.http.ProblemDetail
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice


@RestControllerAdvice(assignableTypes = [UtilisateurController::class])

class UtilisateurControllerAdvice {

    @ExceptionHandler(ProduitsIntrouvableException::class)
    fun error404(exception: ProduitsIntrouvableException) : ProblemDetail{
        return ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, exception.message)
    }

    @ExceptionHandler(ProduitIntrouvableDansPanierException::class)
    fun error404(exception: ProduitIntrouvableDansPanierException) : ProblemDetail{
        return ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, exception.message)
    }
    @ExceptionHandler(ProduitInnexistantException::class)
    fun error400(exception: UtilisateurException) : ProblemDetail{
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, exception.message)
    }

    @ExceptionHandler(IllegalArgumentException::class)
    fun error400(exception: IllegalArgumentException) : ProblemDetail{
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, exception.message?:"")
    }
}