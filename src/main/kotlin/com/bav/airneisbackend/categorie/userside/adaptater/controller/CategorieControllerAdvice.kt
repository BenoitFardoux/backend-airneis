package com.bav.airneisbackend.categorie.userside.adaptater.controller

import com.bav.airneisbackend.categorie.domain.exception.CategorieInvalideException
import com.bav.airneisbackend.categorie.userside.dto.ChampsManquantRestRessource
import org.springdoc.api.ErrorMessage
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice


@RestControllerAdvice(assignableTypes = [CategorieController::class])
class CategorieControllerAdvice {
    @ExceptionHandler(NotImplementedError::class)
    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    fun notYetImplemented(exception: Exception) = ErrorMessage(exception.message)

    @ExceptionHandler(CategorieInvalideException::class)
    fun error400(exception: CategorieInvalideException) =
        ResponseEntity.badRequest().body(ChampsManquantRestRessource(exception.champs,exception.description))
}