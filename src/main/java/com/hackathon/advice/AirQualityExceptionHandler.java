package com.hackathon.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.hackathon.response.AirQualityControllerErrorResponse;

@ControllerAdvice("com.hackathon.controller")
public class AirQualityExceptionHandler {

  @ExceptionHandler
  public ResponseEntity<AirQualityControllerErrorResponse> handleException(Exception exception) {
    AirQualityControllerErrorResponse response = new AirQualityControllerErrorResponse(
        HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getMessage(), System.currentTimeMillis());
    return new ResponseEntity<AirQualityControllerErrorResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
  }

}
