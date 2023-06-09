package com.microprac.springsecurityJWT.system.exception;

import com.microprac.springsecurityJWT.system.constant.ErrorCode;
import io.netty.util.internal.ObjectUtil;
import org.springframework.security.core.parameters.P;
import org.springframework.util.ObjectUtils;

import java.util.HashMap;
import java.util.Map;

public class BaseException extends RuntimeException{

    private final ErrorCode errorCode;

    private final transient HashMap<String, Object> data = new HashMap<>();

    BaseException(ErrorCode errorCode, Map<String, Object> data) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
        if (!ObjectUtils.isEmpty(data)) {
            this.data.putAll(data);
        }
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public Map<String, Object> getData() {
        return data;
    }

}
