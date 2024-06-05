package com.bav.airneisbackend.materiaux.userside.adaptater.controller

import com.bav.airneisbackend.categorie.userside.adaptater.controller.CategorieController
import com.bav.airneisbackend.materiaux.domain.exception.MateriauNonTrouveException
import org.springframework.http.HttpStatus
import org.springframework.http.ProblemDetail
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice(assignableTypes = [ReferentielDeMateriauController::class])
class MateriauControllerAdvice {
    @ExceptionHandler(MateriauNonTrouveException::class)
    fun error404(exception: MateriauNonTrouveException) =
        ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, exception.message)

}