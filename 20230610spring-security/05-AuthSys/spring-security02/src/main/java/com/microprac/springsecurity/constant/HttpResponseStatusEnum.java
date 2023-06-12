package com.microprac.springsecurity.constant;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum HttpResponseStatusEnum implements CommonResponse {

    SUCCESS("0", "success"),                // request success
    FORBIDDEN_OPERATION("2", "can_not_access_need_auth");      // no authorization

    private String code;
    private String message;

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String getResult() {
        return null;
    }
}
