package com.barkavia.api.config

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException

@ControllerAdvice
internal class GlobalExceptionHandler {

    private val log: Logger = LoggerFactory.getLogger(this::class.java)

    @ExceptionHandler(
        IllegalArgumentException::class,
        MethodArgumentTypeMismatchException::class,
        IllegalStateException::class
    )
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun acceptNoGuiltExceptionHandler(e: RuntimeException): ResponseEntity<ErrorResponse> {
        log.error("Runtime exceptions occurred", e)
        return "Sorry, we can't process your request.".asErrorResponse(HttpStatus.BAD_REQUEST)
    }

    private fun String.asErrorResponse(status: HttpStatus): ResponseEntity<ErrorResponse> {
        val errorResponse = ErrorResponse(
            status = status.value(),
            message = this
        )
        return ResponseEntity(errorResponse, status)
    }
}

internal data class ErrorResponse(
    val status: Int,
    val message: String
)