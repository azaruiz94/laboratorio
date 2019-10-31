package com.fiuni.sd.exceptions.iva;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class IvaNotFoundAdvice {

  @ResponseBody
  @ExceptionHandler(IvaNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String ivaNotFoundHandler(IvaNotFoundException ex) {
    return ex.getMessage();
  }
}