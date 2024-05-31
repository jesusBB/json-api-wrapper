package com.testing.response.wrapper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FootballServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(FootballServiceApplication.class, args);
  }

}
