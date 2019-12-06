package bingguo.api;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/9/21
 **/
public class ApiException extends Exception {
    private String errCode;
    private String errMsg;
    private String subErrCode;
    private String subErrMsg;

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getSubErrCode() {
        return subErrCode;
    }

    public void setSubErrCode(String subErrCode) {
        this.subErrCode = subErrCode;
    }

    public String getSubErrMsg() {
        return subErrMsg;
    }

    public void setSubErrMsg(String subErrMsg) {
        this.subErrMsg = subErrMsg;
    }

    public ApiException() {
        super();
    }

    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApiException(String message) {
        super(message);
    }

    public ApiException(Throwable cause) {
        super(cause);
    }

    public ApiException(String errCode, String errMsg) {
        super(errCode + ":" + errMsg);
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public ApiException(String errCode, String errMsg, String subErrCode, String subErrMsg) {
        super(errCode + ":" + errMsg + ":" + subErrCode + ":" + subErrMsg);
        this.errCode = errCode;
        this.errMsg = errMsg;
        this.subErrCode = subErrCode;
        this.subErrMsg = subErrMsg;
    }
}
