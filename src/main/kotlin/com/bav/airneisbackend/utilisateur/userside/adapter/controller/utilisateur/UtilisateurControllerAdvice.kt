package com.bav.airneisbackend.utilisateur.userside.adapter.controller.utilisateur

import com.bav.airneisbackend.utilisateur.serverside.exception.AdresseIntrouvableException
import com.bav.airneisbackend.utilisateur.serverside.exception.AdresseInvalideException
import com.bav.airneisbackend.utilisateur.serverside.exception.MoyenDePaiementsInvalideException
import com.bav.airneisbackend.utilisateur.serverside.exception.ProduitInnexistantException
import com.bav.airneisbackend.utilisateur.serverside.exception.ProduitsIntrouvableException
import com.bav.airneisbackend.utilisateur.serverside.exception.UtilisateurException
import com.bav.airneisbackend.utilisateur.userside.adapter.controller.adresse.AdresseController
import com.bav.airneisbackend.utilisateur.userside.adapter.controller.panier.PanierController
import org.springframework.http.HttpStatus
import org.springframework.http.ProblemDetail
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice


@RestControllerAdvice(assignableTypes = [UtilisateurController::class, PanierController::class, AdresseController::class])

class UtilisateurControllerAdvice {

    @ExceptionHandler(AdresseInvalideException::class)
    fun error400(exception: AdresseInvalideException) : ProblemDetail{
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, exception.message)
    }

    @ExceptionHandler(ProduitsIntrouvableException::class)
    fun error404(exception: ProduitsIntrouvableException) : ProblemDetail{
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

    @ExceptionHandler(MoyenDePaiementsInvalideException::class)
    fun error400(exception: MoyenDePaiementsInvalideException) : ProblemDetail{
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, exception.message)
    }

    @ExceptionHandler(AdresseIntrouvableException::class)
    fun error404(exception: AdresseIntrouvableException) : ProblemDetail{
        return ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, exception.message)
    }
}