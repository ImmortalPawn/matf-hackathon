package com.hackathon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.entity.AirQuality;
import com.hackathon.entity.Weather;
import com.hackathon.service.AirQualityService;

@RestController
@RequestMapping("/api/airquality")
public class AirQualityController {

  @Autowired
  private AirQualityService airQualityService;

//  @PostMapping("/quality")
//  public AirQuality getQuality(@RequestBody Weather weather) {
//    return airQualityService.getQuality(weather);
//  }

  @CrossOrigin
  @GetMapping("/quality")
  public AirQuality getQuality(@RequestParam int vreme, @RequestParam int temperatura,
      @RequestParam int vlaznost, @RequestParam double pritisak, @RequestParam double brzina,
      @RequestParam int oblacnost, @RequestParam int danUNedelji,
      @RequestParam int mesec) {
    return airQualityService.getQuality(
        new Weather(vreme, temperatura, vlaznost, pritisak, brzina, oblacnost, danUNedelji, mesec));
  }

}
