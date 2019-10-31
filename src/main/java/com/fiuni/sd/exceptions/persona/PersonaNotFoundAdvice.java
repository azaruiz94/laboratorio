package com.fiuni.sd.exceptions.persona;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class PersonaNotFoundAdvice {

  @ResponseBody
  @ExceptionHandler(PersonaNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String personaNotFoundHandler(PersonaNotFoundException ex) {
    return ex.getMessage();
  }
}