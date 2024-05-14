package com.swontech.s05.config;

import com.swontech.s05.service.common.CustomException;
import com.swontech.s05.service.common.CustomResponse;
import com.swontech.s05.service.common.ExceptionEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class ControllerExceptionHandler {
    private final CustomResponse customResponse;
    public ControllerExceptionHandler(CustomResponse customResponse) {
        this.customResponse = customResponse;
    }

   @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
   public ResponseEntity handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
      log.error("=======================================");
      log.error("해당 컨트롤러는 '{}' 메소드를 지원하지 않습니다.", e.getMethod());
      log.error("=======================================");

      throw new CustomException(ExceptionEnum.METHOD_NOT_ALLOWED);
   }
}
