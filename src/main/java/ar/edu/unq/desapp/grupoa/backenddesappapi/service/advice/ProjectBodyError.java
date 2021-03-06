package ar.edu.unq.desapp.grupoa.backenddesappapi.service.advice;

import ar.edu.unq.desapp.grupoa.backenddesappapi.exception.InvalidOrNullFieldException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ProjectBodyError {

    @ResponseBody
    @ExceptionHandler(InvalidOrNullFieldException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String invalidOrNullFieldException(InvalidOrNullFieldException ex) {
        return ex.getMessage();
    }

}