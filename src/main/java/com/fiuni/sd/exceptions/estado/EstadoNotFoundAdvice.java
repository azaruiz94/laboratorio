package com.fiuni.sd.exceptions.estado;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class EstadoNotFoundAdvice {

  @ResponseBody
  @ExceptionHandler(EstadoNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String estadoNotFoundHandler(EstadoNotFoundException ex) {
    return ex.getMessage();
  }
}