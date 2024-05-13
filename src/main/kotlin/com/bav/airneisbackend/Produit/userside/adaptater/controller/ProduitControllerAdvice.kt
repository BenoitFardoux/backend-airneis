package com.bav.airneisbackend.Produit.userside.adaptater.controller

import com.bav.airneisbackend.Produit.domain.exception.AucunProduitTrouveException
import org.springdoc.api.ErrorMessage
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.lang.Exception


@RestControllerAdvice(assignableTypes = [ProduitController::class])
class ProduitControllerAdvice {
    @ExceptionHandler(AucunProduitTrouveException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun error404(exception: Exception) : String{
        return exception.localizedMessage
    }


    @ExceptionHandler(NotImplementedError::class)
    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    fun notYetImplemented(exception: Exception)  = ErrorMessage(exception.message)


}