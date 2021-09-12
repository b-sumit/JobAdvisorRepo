package com.chameleon.assignment.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class AdvisorExceptionHandler extends ResponseEntityExceptionHandler {

  private static final Logger log = LoggerFactory.getLogger(AdvisorExceptionHandler.class);

  @ExceptionHandler({AdvisorException.class})
  public ResponseEntity<ErrorResponse> handleAdvisorException(AdvisorException ex, WebRequest request) {
    ErrorResponse errorResponse = createErrorResponse(ex.getMessage(), ex);
    return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(ex.getCode()));
  }

  private ErrorResponse createErrorResponse(String message, Exception ex) {
    ErrorResponse errorResponse = new ErrorResponse();
    errorResponse.setMessage(message);
    log.error(ex.getMessage(), ex);
    return errorResponse;
  }

}