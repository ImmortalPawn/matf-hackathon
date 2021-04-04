package com.hackathon.exception;


public class ParseAirQualityData extends RuntimeException {

  public ParseAirQualityData() {
    super();
  }

  public ParseAirQualityData(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

  public ParseAirQualityData(String message, Throwable cause) {
    super(message, cause);
  }

  public ParseAirQualityData(String message) {
    super(message);
  }

  public ParseAirQualityData(Throwable cause) {
    super(cause);
  }

}
