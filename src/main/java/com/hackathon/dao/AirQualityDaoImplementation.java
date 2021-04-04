package com.hackathon.dao;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackathon.entity.AirQuality;
import com.hackathon.entity.Weather;
import com.hackathon.exception.GenerateAirQualityException;
import com.hackathon.exception.GenerateWeatherDataException;
import com.hackathon.exception.ParseAirQualityData;

@Repository
public class AirQualityDaoImplementation implements AirQualityDao {

  private static final Path filesPath = FileSystems.getDefault()
      .getPath("/home/mladjan/Documents/Workspace/Eclipse/jee-2020-03/hackathon");

  private static final String scriptsDirName = "ML";

  private static final String weatherDataFileName = "weather.json";

  @Override
  public AirQuality getQuality(Weather weather) {
    try {
      generateWeatherData(weather);
    } catch (Exception exception) {
      throw new GenerateWeatherDataException(
          "Weather data could not be generated. Reason -> " + exception.getMessage());
    }
    try {
      if (generateAirQualityData() != 0) {
        throw new Exception("Script returned with exit value different than 0");
      }
    } catch (Exception exception) {
      throw new GenerateAirQualityException(
          "AirQuality data could not be generated. Reason: " + exception.getMessage());
    }
    AirQuality airQuality = null;
    try {
      airQuality = parseAirQualityData();
      if (airQuality == null) {
        throw new Exception("Could not create AirQuality object");
      }
    } catch (Exception exception) {
      throw new ParseAirQualityData(
          "AirQuality object could not be created. Reason: " + exception.getMessage());
    }
    return airQuality;
  }

  private boolean generateWeatherData(Weather weather)
      throws JsonGenerationException, JsonMappingException, IOException {
    ObjectMapper objectMapper = new ObjectMapper();
    Path path = filesPath.resolve(scriptsDirName).resolve(weatherDataFileName);
    System.out.println("generateWeatherData path: " + path.toAbsolutePath().toString());
    objectMapper.writeValue(path.toFile(), weather);
    return true;
  }

  private int generateAirQualityData() throws IOException, InterruptedException {
    String programName = "python3";
    final String generateAirQualityDataScriptName = "mreza.py";
    String cmdArray[] = {programName, generateAirQualityDataScriptName, weatherDataFileName};
    System.out.println("generateAirQualityData script call: python3 "
        + generateAirQualityDataScriptName + " " + weatherDataFileName);
    Path path = filesPath.resolve(scriptsDirName);
    System.out.println("generateAirQualityData path: " + path.toString());
    Process process = Runtime.getRuntime().exec(cmdArray, null, path.toFile());
    process.waitFor();
    return process.exitValue();
  }

  private AirQuality parseAirQualityData()
      throws JsonParseException, JsonMappingException, IOException {
    final String generatedDataDirName = "izlazi";
    final String airQualityDataFileName = "predvidjanje.txt";
    ObjectMapper objectMapper = new ObjectMapper();
    Path path = filesPath.resolve(scriptsDirName).resolve(generatedDataDirName)
        .resolve(airQualityDataFileName);
    return objectMapper.readValue(path.toFile(), AirQuality.class);
  }

}
