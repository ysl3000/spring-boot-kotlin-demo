package hello.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

/**
 * Created by ysl3000
 */
@ControllerAdvice
@RestController
class ErrorController : ResponseEntityExceptionHandler() {

    @ExceptionHandler()
    fun error( ex : Exception,  request: WebRequest): ResponseEntity<String> {
        return ResponseEntity(ex.message,HttpStatus.NOT_FOUND)
    }

}


