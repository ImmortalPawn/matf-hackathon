package com.hackathon.exception;

public class GenerateAirQualityException extends RuntimeException {

  public GenerateAirQualityException() {
    super();
  }

  public GenerateAirQualityException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

  public GenerateAirQualityException(String message, Throwable cause) {
    super(message, cause);
  }

  public GenerateAirQualityException(String message) {
    super(message);
  }

  public GenerateAirQualityException(Throwable cause) {
    super(cause);
  }

}
