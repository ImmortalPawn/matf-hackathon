package com.hackathon.service;

import com.hackathon.entity.AirQuality;
import com.hackathon.entity.Weather;

public interface AirQualityService {

  AirQuality getQuality(Weather weather);

}
