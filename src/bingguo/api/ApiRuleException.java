package bingguo.api;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/9/23
 **/
public class ApiRuleException extends ApiException {
    public ApiRuleException(String errCode, String errMsg) {
        super(errCode, errMsg);
    }
}
