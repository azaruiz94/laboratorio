package com.fiuni.sd.exceptions.sexo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class SexoNotFoundAdvice {

  @ResponseBody
  @ExceptionHandler(SexoNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String sexoNotFoundHandler(SexoNotFoundException ex) {
    return ex.getMessage();
  }
}