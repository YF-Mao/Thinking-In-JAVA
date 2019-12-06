package bingguo.api;

import java.util.Map;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/9/21
 **/
public interface BaseRequest<T extends BaseResponse> {

    /**
     * 获取响应类
     *
     */
    Class<T> getResponseClass();

    /**
     * 获取请求方式，包含xml,json,form
     *
     */
    String getContentType();

    /**
     * 客户端参数检查
     *
     */
    void check() throws ApiRuleException;

    /**
     * 获取自定义HTTP请求头参数
     * 
     */
    Map<String, String> getHeaderMap();

    /**
     * 获取HTTP 请求方式
     *
     */
    String getHttpMethod();
}
