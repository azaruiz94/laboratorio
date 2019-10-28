package com.fiuni.sd.exceptions.tipo_analisis;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class TipoAnalisisNotFoundAdvice {

  @ResponseBody
  @ExceptionHandler(TipoAnalisisNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String tipoAnalisisNotFoundHandler(TipoAnalisisNotFoundException ex) {
    return ex.getMessage();
  }
}