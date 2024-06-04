package com.bav.airneisbackend.categorie.userside.adaptater.controller

import com.bav.airneisbackend.categorie.domain.exception.CategorieInvalideException
import com.bav.airneisbackend.categorie.domain.exception.CategorieNonTrouveeException
import com.bav.airneisbackend.categorie.userside.dto.ChampsManquantRestRessource
import org.springdoc.api.ErrorMessage
import org.springframework.http.HttpStatus
import org.springframework.http.ProblemDetail
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice


@RestControllerAdvice(assignableTypes = [CategorieController::class])
class CategorieControllerAdvice {
    @ExceptionHandler(NotImplementedError::class)
    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    fun notYetImplemented(exception: Exception) = ErrorMessage(exception.message)

    @ExceptionHandler(CategorieNonTrouveeException::class)
    fun error404(exception: CategorieNonTrouveeException) : ProblemDetail =
        ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, exception.message)

    @ExceptionHandler(CategorieInvalideException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun error400(exception: CategorieInvalideException) =
        ResponseEntity.badRequest().body(ChampsManquantRestRessource(exception.champs,exception.description))

    @ExceptionHandler(IllegalArgumentException::class)
    fun error400(exception: IllegalArgumentException) : ProblemDetail =
        ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, exception.message?:"")

  /*  @ExceptionHandler(Exception::class)
    fun error500(exception: Exception) : ProblemDetail =
        ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, exception.toString()?:"")
*/
}