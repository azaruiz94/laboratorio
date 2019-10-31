package com.fiuni.sd.exceptions.tipo_persona;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class TipoPersonaNotFoundAdvice {

  @ResponseBody
  @ExceptionHandler(TipoPersonaNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String tipoPersonaNotFoundHandler(TipoPersonaNotFoundException ex) {
    return ex.getMessage();
  }
}