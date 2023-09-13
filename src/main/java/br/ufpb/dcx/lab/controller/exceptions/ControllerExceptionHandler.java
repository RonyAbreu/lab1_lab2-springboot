package br.ufpb.dcx.lab.controller.exceptions;

import br.ufpb.dcx.lab.services.exceptions.DisciplinaNotFound;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;
import java.util.List;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler{

    @ExceptionHandler(DisciplinaNotFound.class)
    public ResponseEntity<StandardError> disciplinaNotFound(DisciplinaNotFound e, HttpServletRequest request){
        String error = "Not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now(),status.value(),error,e.getMessage(),request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }


    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request){
        StandardError err = new StandardError(Instant.now(),status.value(),"error",ex.getMessage(),request.getContextPath());
        return new ResponseEntity<>(err,status);
    }

    private List<ErrorObject> getErros(MethodArgumentNotValidException ex){
        return ex.getBindingResult().getFieldErrors()
                .stream().map(error -> new ErrorObject(error.getDefaultMessage(),error.getField())).toList();
    }
}
