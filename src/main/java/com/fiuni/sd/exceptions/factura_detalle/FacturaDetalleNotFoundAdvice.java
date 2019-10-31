package com.fiuni.sd.exceptions.factura_detalle;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class FacturaDetalleNotFoundAdvice {

  @ResponseBody
  @ExceptionHandler(FacturaDetalleNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String facturaDetalleNotFoundHandler(FacturaDetalleNotFoundException ex) {
    return ex.getMessage();
  }
}