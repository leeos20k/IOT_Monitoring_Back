package com.swontech.s05.service.common;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Collections;

@Component
public class CustomResponse {
    private final String SUCCESS = "SUCCESS";
    private final String FAIL = "FAIL";
    private final String EMPTY_STR = "";
    private LocalDateTime currentTime = LocalDateTime.now();


    @Getter
    @Builder
    private static class Body {
        private int status;
        private String result;
        private String message;
        private Object data;
        private Object error;
        private LocalDateTime timestamp;
    }

    public ResponseEntity<Body> success(String message, Object data) {
        Body body = Body.builder()
            .status(HttpStatus.OK.value())
            .result(SUCCESS)
            .message(message)
            .data(data)
            .timestamp(currentTime)
        .build();


        return ResponseEntity.ok(body);
    }

    public ResponseEntity<Body> success(String message) {
        return success(message, Collections.emptyList());
    }

    public ResponseEntity<Body> success(Object data) {
        return success(EMPTY_STR, data);
    }

    public ResponseEntity<Body> fail(CustomException e) {
        return ResponseEntity.ok(
                Body.builder()
                    .status(e.getExceptionEnum().getStatus())
                    .data(e.getExceptionEnum())
                    .result(FAIL)
                    .message(e.getExceptionEnum().getMessage())
                    .timestamp(currentTime)
                .build()
        );
    }
}
