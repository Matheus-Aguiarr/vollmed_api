package com.vollmed.apirest.infra.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalHandlerExceptions {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity handle404() {
        return ResponseEntity.notFound().build();
    }

//        var errors = ex.getFieldErrors();
//        return ResponseEntity.badRequest().body(errors.stream().map(erroValidacaoDTO::new).toList());
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handle400(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors()
                .forEach(e -> errors.put(e.getField(), e.getDefaultMessage()));
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    private record erroValidacaoDTO(String campo, String mensagem) {
        public erroValidacaoDTO(FieldError ex) {
            this(ex.getField(), ex.getDefaultMessage());
        }


    }
}
