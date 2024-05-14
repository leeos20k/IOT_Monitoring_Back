package com.swontech.s05.service.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ExceptionEnum {
    // Third API에러
    EXTERNAL_SERVER_ERROR(500, "D001", "인증번호 알림톡을 발송하는데 실패했습니다."),

    // Jwt Auth
    INVALID_JWT(401, "A001", "로그인 인증 정보가 올바르지 않습니다.\n다시 로그인해주세요."),
    EXPIRED_JWT(401, "A002", "로그인 세션이 만료되었습니다.\n다시 로그인해주세요."),
    UNSUPPORTED_JWT(401, "A003", "로그인 인증 정보가 올바르지 않습니다.\n다시 로그인해주세요."),
    CLAIMS_EMPTY_JWT(401, "A004", "로그인 인증 정보가 올바르지 않습니다.\n다시 로그인해주세요."),

    // 인증 정보 에러
    USER_NOT_FOUND(403, "A005", "직번을 다시 확인하세요."),
    NOT_PERMITTED_CLIENT_IP(403, "A006", "접속경로를 다시 확인해주세요."),
    INVALID_CLIENT_IP(403, "A007", "클라이언트 IP가 정확하지 않습니다."),
    INVALID_PASSWORD(403, "A008", "비밀번호를 다시 확인해주세요."),

    // 기본 에러
    INTERNAL_SERVER_ERROR(500, "C001", "오류가 발생했습니다."),
    METHOD_NOT_ALLOWED(405, "A007", "요청 메소드를 확인해주세요."),
    ;

    private int status;
    private String code;
    private String message;

    ExceptionEnum(int status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
    public String getCode() {
        return this.code;
    }
    public String getMessage() {
        return this.message;
    }
}