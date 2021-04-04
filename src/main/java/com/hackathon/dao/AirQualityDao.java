package com.hackathon.dao;

import com.hackathon.entity.AirQuality;
import com.hackathon.entity.Weather;

public interface AirQualityDao {

  AirQuality getQuality(Weather weather);

}
