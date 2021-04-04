package com.hackathon.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AirQuality {

  @JsonProperty("PM10")
  private double pm10;

  public AirQuality() {
  }

  public double getPm10() {
    return pm10;
  }

  public void setPm10(double pm10) {
    this.pm10 = pm10;
  }

}
