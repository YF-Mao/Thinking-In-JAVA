package bingguo.api;

import java.util.Map;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/9/25
 **/
public interface BaseUploadRequest<T extends BaseResponse> extends BaseRequest {
    Map<String, BaseFile> getFileParams();
}
