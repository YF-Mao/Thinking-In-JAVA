package bingguo.api.internal.mapping;

import bingguo.api.ApiException;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/9/21
 **/
public interface Convert {
    /**
     * 把字符串转换为响应对象
     * @author YF.Mao
     * @param <T> 泛型
     * @param rsp 响应字符串
     * @param clazz 特定类型
     * @return 响应对象
     * @throws ApiException
     *
     */
    <T> T toResponse(String rsp, Class<T> clazz) throws ApiException;
}
