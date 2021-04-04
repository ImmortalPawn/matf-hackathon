package com.hackathon.exception;


public class GenerateWeatherDataException extends RuntimeException {

  public GenerateWeatherDataException() {
    super();
  }

  public GenerateWeatherDataException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

  public GenerateWeatherDataException(String message, Throwable cause) {
    super(message, cause);
  }

  public GenerateWeatherDataException(String message) {
    super(message);
  }

  public GenerateWeatherDataException(Throwable cause) {
    super(cause);
  }

}
