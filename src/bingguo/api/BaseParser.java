package bingguo.api;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/9/21
 **/
public interface BaseParser<T> {
    /**
     * 把响应字符串解释成特定对象
     *
     * @param rsp          响应字符串
     * @param responseType 响应格式
     * @return 领域对象
     * @throws ApiException
     * @author YF.Mao
     */
    T parse(String rsp, String responseType) throws ApiException;

    /**
     * 获取响应类类型
     *
     * @return java类类型
     * @throws ApiException
     * @author YF.Mao
     */
    Class<T> getResponseClass() throws ApiException;
}
