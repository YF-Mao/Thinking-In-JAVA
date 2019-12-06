package bingguo.api.internal.parser;

import bingguo.api.ApiException;
import bingguo.api.BaseParser;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/9/21
 **/
public class ObjectJsonParser<T> implements BaseParser<T> {
    private Class<T> clazz;

    public ObjectJsonParser(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public T parse(String rsp, String responseType) throws ApiException {
        return null;
    }

    @Override
    public Class<T> getResponseClass() throws ApiException {
        return clazz;
    }
}
