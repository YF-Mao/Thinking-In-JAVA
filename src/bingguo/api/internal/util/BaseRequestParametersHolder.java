package bingguo.api.internal.util;

import java.util.Map;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/9/23
 **/
public class BaseRequestParametersHolder {
    private Map<String,String> map;

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }
}
