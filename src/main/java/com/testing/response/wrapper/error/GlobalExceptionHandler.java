package com.testing.response.wrapper.error;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.FeignException;
import feign.RetryableException;
import java.util.ArrayList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

  private static final String INTERNAL_ERROR_TITLE = "Internal error";
  private static final int INTERNAL_ERROR_STATUS_CODE = 500;

}
