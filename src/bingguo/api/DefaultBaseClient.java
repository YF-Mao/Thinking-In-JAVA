package bingguo.api;

import bingguo.api.internal.dto.BaseRequestDTO;
import bingguo.api.internal.mapping.BaseRequestBodyConverter;
import bingguo.api.internal.parser.ObjectJsonParser;
import bingguo.api.internal.util.BaseRequestParametersHolder;
import util.StringUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/9/21
 **/
public class DefaultBaseClient implements BaseClient {
    @Override
    public <T extends BaseResponse> T execute(BaseRequest<T> request) throws ApiException {
        return execute(request, null);
    }

    @Override
    public <T extends BaseResponse> T execute(BaseRequest<T> request, String session) throws ApiException {
        return _execute(request, session);
    }

    private <T extends BaseResponse> T _execute(BaseRequest<T> request, String session) throws ApiException {
        long start = System.currentTimeMillis();

        BaseParser<T> parser = buildParser(request);
        try {
            request.check();
        } catch (ApiRuleException e) {
            T localResponse = null;
            try {
                localResponse = request.getResponseClass().newInstance();
            } catch (Exception xe) {
                throw new ApiException(xe);
            }
            localResponse.setErrorCode(e.getErrCode());
            localResponse.setMsg(e.getErrMsg());
            return localResponse;
        }

        BaseRequestParametersHolder holder = invokeApi(request, session, start);
        return null;
    }

    private <T extends BaseResponse> BaseRequestParametersHolder invokeApi(BaseRequest<T> request, String session, long start) throws ApiException {
        BaseRequestDTO baseRequestDTO = new BaseRequestDTO();
        baseRequestDTO.setRequestBase(request);
        if (StringUtil.isEmpty(baseRequestDTO.getBody())) {
            baseRequestDTO.setBody(BaseRequestBodyConverter.getRequestBody(request, request.getContentType()));
        }
        return invokeApi(baseRequestDTO, session, start);
    }

    private <T extends BaseResponse> BaseRequestParametersHolder invokeApi(BaseRequestDTO requestDTO, String session, long start) throws ApiException {
        BaseRequestParametersHolder requestHolder = new BaseRequestParametersHolder();

        String apiBody = requestDTO.getBody();
        try {
            if (requestDTO.getRequestBase() != null && requestDTO.getRequestBase() instanceof BaseUploadRequest) {
                BaseUploadRequest<?> uploadRequest = (BaseUploadRequest<?>) requestDTO.getRequestBase();
            } else {
                byte[] bodyByte = apiBody == null ? new byte[0] : apiBody.getBytes(Constants.CHARSET_UTF8);
            }
        } catch (IOException e) {

        }

        return requestHolder;
    }

    private <T extends BaseResponse> BaseParser<T> buildParser(BaseRequest<T> request) {
        BaseParser<T> parser = null;
        parser = new ObjectJsonParser<>(request.getResponseClass());
        return parser;
    }

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("1", "yi");
        BaseRequestParametersHolder baseRequestParametersHolder = new BaseRequestParametersHolder();
        baseRequestParametersHolder.setMap(map);

        map.put("2", "er");
        System.out.println(baseRequestParametersHolder.getMap());
    }
}
