package com.game.community.server.exception;

import lombok.ToString;
import org.springframework.http.HttpStatus;

@ToString
public enum ResponseCode {

    // HTTP Status 200
    SUCCESS("SU", "Success", HttpStatus.OK),

    // HTTP Status 400
    VALIDATION_FAILED("VF", "Validation Failed", HttpStatus.BAD_REQUEST),
    DUPLICATE_EMAIL("DE", "Duplicate Email", HttpStatus.BAD_REQUEST),
    DUPLICATE_NICKNAME("DN", "Duplicate Nickname", HttpStatus.BAD_REQUEST),
    //DUPLICATE_TEL_NUMBER("DT", "Duplicate Tel Number", HttpStatus.BAD_REQUEST),
    NOT_EXISTED_USER("NU", "User does not exist", HttpStatus.BAD_REQUEST),
    NOT_EXISTED_BOARD("NB", "Board does not exist", HttpStatus.BAD_REQUEST),

    // HTTP Status 401
    SIGN_IN_FAILED("SF", "Sign in failed", HttpStatus.UNAUTHORIZED),
    AUTHORIZATION_FAILED("AF", "Authorization failed", HttpStatus.UNAUTHORIZED),

    // HTTP Status 403
    NO_PERMISSION("NP", "No permission", HttpStatus.FORBIDDEN),

    // HTTP Status 500
    DATABASE_ERROR("DBE", "Database error", HttpStatus.INTERNAL_SERVER_ERROR);

    private final String code;
    private final String message;
    private final HttpStatus httpStatus;


    ResponseCode(String code, String message, HttpStatus httpStatus) {
        this.code = code;
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

}
