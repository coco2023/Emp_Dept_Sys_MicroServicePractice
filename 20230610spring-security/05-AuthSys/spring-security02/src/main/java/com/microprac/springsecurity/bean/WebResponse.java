package com.microprac.springsecurity.bean;

import com.microprac.springsecurity.constant.CommonResponse;
import com.microprac.springsecurity.constant.HttpResponseStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * format All HTTP web responses
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WebResponse {

    private String code;

    private String message;

    private Object result;

    public WebResponse(HttpResponseStatusEnum httpResponseStatusEnum) {
        this.code = httpResponseStatusEnum.getCode();
        this.message = httpResponseStatusEnum.getMessage();
    }

    public WebResponse(CommonResponse commonResponse) {
        this.code = commonResponse.getCode();
        this.message = commonResponse.getMessage();
    }

    /**
     * success
     */
    public static WebResponse success() {
        return new WebResponse(HttpResponseStatusEnum.SUCCESS.getCode(), HttpResponseStatusEnum.SUCCESS.getMessage(), null);
    }

    /**
     * success
     */
    public static WebResponse success(Object result) {
        return new WebResponse(HttpResponseStatusEnum.SUCCESS.getCode(),HttpResponseStatusEnum.SUCCESS.getMessage(), result );
    }

    /**
     * forbidden http request
     */
    public static WebResponse forbidden() {
        return new WebResponse(
                HttpResponseStatusEnum.FORBIDDEN_OPERATION.getCode(),
                HttpResponseStatusEnum.FORBIDDEN_OPERATION.getMessage(),
                null
        );
    }

}
