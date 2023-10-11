package br.ufpb.dcx.lab.controller.exceptions;

import br.ufpb.dcx.lab.services.exceptions.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class ControllerExceptionHandler{

    @ExceptionHandler(DisciplinaNotFound.class)
    public ResponseEntity<StandardError> disciplinaNotFound(DisciplinaNotFound e, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now(),e.getMessage(),status.value(),request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(TagAlreadyExistsException.class)
    public ResponseEntity<StandardError> tagDuplicateError(TagAlreadyExistsException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.CONFLICT;
        StandardError err = new StandardError(Instant.now(),e.getMessage(),status.value(),request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(DisciplinaAlreadyExistsException.class)
    public ResponseEntity<StandardError> disciplineDuplicateError(DisciplinaAlreadyExistsException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.CONFLICT;
        StandardError err = new StandardError(Instant.now(),e.getMessage(),status.value(),request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<StandardError> dataIntegrityError(DataIntegrityViolationException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError(Instant.now(),e.getMessage(),status.value(),request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<StandardError> constraintViolationError(ConstraintViolationException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        StandardError err = new StandardError(Instant.now(),e.getMessage(),status.value(),request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> methodArgumentError(MethodArgumentNotValidException e, HttpServletRequest request){
        ValidationError err = new ValidationError(Instant.now(),"Validation Error",HttpStatus.BAD_REQUEST.value(), request.getRequestURI());
        for (FieldError fieldError : e.getBindingResult().getFieldErrors()){
            err.addErros(fieldError.getField(),fieldError.getDefaultMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }

    @ExceptionHandler(UsuarioJaExisteException.class)
    public ResponseEntity<StandardError> usuarioJaExisteError(UsuarioJaExisteException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.CONFLICT;
        StandardError err = new StandardError(Instant.now(),e.getMessage(),status.value(),request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(UsuarioNaoExisteException.class)
    public ResponseEntity<StandardError> usuarioNaoExisteError(UsuarioNaoExisteException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now(),e.getMessage(),status.value(),request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(LoginInvalidoException.class)
    public ResponseEntity<StandardError> loginInvalidoError(LoginInvalidoException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError(Instant.now(),e.getMessage(),status.value(),request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(UsuarioNaoTemPermissaoException.class)
    public ResponseEntity<StandardError> usuarioNaoTemPermissaoError(UsuarioNaoTemPermissaoException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.FORBIDDEN;
        StandardError err = new StandardError(Instant.now(),e.getMessage(),status.value(),request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(SecurityException.class)
    public ResponseEntity<StandardError> erroDeSegurancaDoToken(SecurityException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.FORBIDDEN;
        StandardError err = new StandardError(Instant.now(),e.getMessage(),status.value(),request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

}
