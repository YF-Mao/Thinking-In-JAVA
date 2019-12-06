package bingguo.api.internal.dto;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/9/23
 **/
public class BaseRequestDTO {
    private Object requestBase;
    private String body;

    public Object getRequestBase() {
        return requestBase;
    }

    public void setRequestBase(Object requestBase) {
        this.requestBase = requestBase;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
