package bingguo.api;

import bingguo.api.internal.annotation.BaseErrorField;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/9/21
 **/
public abstract class BaseResponse {
    @BaseErrorField("code")
    private String code;

    @BaseErrorField("code")
    private String errorCode;

    @BaseErrorField("msg")
    private String message;

    @BaseErrorField("msg")
    private String msg;

    @BaseErrorField("count")
    private String count;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}
