package bingguo.api;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/9/21
 **/
public interface BaseClient {
    <T extends BaseResponse> T execute(BaseRequest<T> request) throws ApiException;

    <T extends BaseResponse> T execute(BaseRequest<T> request, String session) throws ApiException;
}
