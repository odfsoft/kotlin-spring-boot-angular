package com.odfsoft.kotlinspringbootangular.exception

import com.odfsoft.kotlinspringbootangular.utils.logger
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class GlobalExceptionHandler : ResponseEntityExceptionHandler() {
    private val log = logger()

    @ExceptionHandler(value = [Exception::class])
    fun handle(ex: RuntimeException, request: WebRequest): ResponseEntity<ErrorDetails> {
        log.error( "unexpected exception found", ex)

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ErrorDetails("Sorry about that, something went wrong on our end!"))
    }

    @ExceptionHandler(value = [EmployeeNotFoundException::class])
    fun handleEmployeeNotFound(ex: RuntimeException, request: WebRequest): ResponseEntity<ErrorDetails> {
        log.warn(ex.message)

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ErrorDetails(ex.message ?: "Sorry about that, something went wrong on our end!"))
    }

    data class ErrorDetails(val msg: String)
}