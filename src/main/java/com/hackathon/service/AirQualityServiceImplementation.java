package com.hackathon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathon.dao.AirQualityDao;
import com.hackathon.entity.AirQuality;
import com.hackathon.entity.Weather;

@Service
public class AirQualityServiceImplementation implements AirQualityService {

  @Autowired
  private AirQualityDao airQualityDao;

  @Override
  public AirQuality getQuality(Weather weather) {
    return airQualityDao.getQuality(weather);
  }

}
