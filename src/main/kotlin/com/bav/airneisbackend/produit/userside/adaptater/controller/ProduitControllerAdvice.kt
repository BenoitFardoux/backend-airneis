package com.bav.airneisbackend.produit.userside.adaptater.controller

import com.bav.airneisbackend.produit.domain.exception.AucunProduitTrouveException
import com.bav.airneisbackend.produit.domain.exception.MateriauDuProduitIntrouvable
import com.bav.airneisbackend.produit.domain.exception.ProduitInvalideException
import com.bav.airneisbackend.produit.userside.restressources.exception.ChampsManquantRestRessource
import org.springdoc.api.ErrorMessage
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.lang.Exception


@RestControllerAdvice(assignableTypes = [ProduitController::class])
class ProduitControllerAdvice {
    @ExceptionHandler(AucunProduitTrouveException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun error404(exception: AucunProduitTrouveException) : String{
        return exception.description
    }


    @ExceptionHandler(NotImplementedError::class)
    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    fun notYetImplemented(exception: Exception)  = ErrorMessage(exception.message)

    @ExceptionHandler(ProduitInvalideException::class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun error400(exception: ProduitInvalideException) : ResponseEntity<ChampsManquantRestRessource>{
        return ResponseEntity.badRequest().body(ChampsManquantRestRessource(exception.message,exception.champs))
    }

    @ExceptionHandler(MateriauDuProduitIntrouvable::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun error400(exception: MateriauDuProduitIntrouvable) : String{
        return exception.description
    }
}