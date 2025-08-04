package com.kelly.Compra_usuario_padaria.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object>handleGenericException(Exception ex){
        Map<String,Object> body=new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        body.put("error","Erro Interno no servidor");
        body.put("message",ex.getMessage());
        return  new ResponseEntity<>(body,HttpStatus.INTERNAL_SERVER_ERROR);

    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object>handleValidationException(MethodArgumentNotValidException ex){
        Map<String,Object>body=new HashMap<>();
        body.put("timestamp",LocalDateTime.now());
        body.put("status",HttpStatus.BAD_REQUEST.value());
        body.put("error","Erro de validacao");

        Map<String,String> fieldErrors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach((FieldError error) ->
                fieldErrors.put(error.getField(), error.getDefaultMessage())
        );

        body.put("fielErros",fieldErrors);
        return new ResponseEntity<>(body,HttpStatus.BAD_REQUEST);



    }
}
