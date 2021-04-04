package com.hackathon.configuration;

import java.util.logging.Logger;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan("com.hackathon")
public class ApplicationConfiguration {

  private Logger logger = Logger.getLogger(getClass().getName());

}
