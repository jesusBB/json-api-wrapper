package com.testing.response.wrapper.config;

import feign.Feign;
import feign.okhttp.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientConfig {
  @Bean
  public Feign.Builder feignBuilder() {
    return Feign.builder().client(new OkHttpClient());
  }
}
