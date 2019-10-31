package com.fiuni.sd.exceptions.factura;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class FacturaNotFoundAdvice {

  @ResponseBody
  @ExceptionHandler(FacturaNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String facturaNotFoundHandler(FacturaNotFoundException ex) {
    return ex.getMessage();
  }
}