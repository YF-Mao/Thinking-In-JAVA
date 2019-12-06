package bingguo.api.internal.mapping;

import bingguo.api.Constants;
import bingguo.api.internal.annotation.ApiBodyField;
import com.alibaba.fastjson.JSONObject;
import netscape.javascript.JSObject;
import util.StringUtil;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/9/23
 **/
public class BaseRequestBodyConverter {
    public static String getRequestBody(Object baseRequest, String type) {
        if (baseRequest == null) {
            return null;
        }
        Field[] fields = baseRequest.getClass().getDeclaredFields();
        Map<String, Object> map = new HashMap<>();
        for (Field field : fields) {
            ApiBodyField apiBodyField = field.getAnnotation(ApiBodyField.class);
            if (apiBodyField == null) {
                continue;
            }
            try {
                field.setAccessible(true);
                if (Constants.FORMAT_JSON.equalsIgnoreCase(type)) {
                    if ("object".equalsIgnoreCase(apiBodyField.value()) || "list".equalsIgnoreCase(apiBodyField.value())) {
                        if (field.get(baseRequest) != null) {
                            map.put(StringUtil.isEmpty(apiBodyField.fieldName()) ? field.getName() : apiBodyField.fieldName(),
                                    JSONObject.parse(field.get(baseRequest).toString()));
                        } else {
                            if (field.get(baseRequest) != null) {
                                map.put(StringUtil.isEmpty(apiBodyField.fieldName()) ? field.getName() : apiBodyField.fieldName(),
                                        field.get(baseRequest).toString());
                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (map.size() == 0) {
            return null;
        }
        return null;
    }
}
