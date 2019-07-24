package net.mindview.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/25
 **/
public class TypeCounter extends HashMap<Class<?>, Integer> {
    private Class<?> baseType;

    public TypeCounter(Class<?> baseType) {
        this.baseType = baseType;
    }

    public void count(Object object) {
        Class<?> type = object.getClass();
        //isAssignableFrom : 判定此 Class 对象所表示的类或接口与指定的 Class 参数所表示的类或接口是否相同，或是否是其超类或超接口
        if (!baseType.isAssignableFrom(type)) {
            throw new RuntimeException(object + " incorrect type:" + type + ", should be type or subtype of "
                    + baseType);
        }
        countClass(type);
    }

    private void countClass(Class<?> type) {
        Integer quantity = get(type);
        put(type, quantity == null ? 1 : quantity + 1);
        Class<?> superClass = type.getSuperclass();
        if (superClass != null && baseType.isAssignableFrom(superClass)) {
            countClass(superClass);
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("{");
        for (Map.Entry<Class<?>, Integer> pair : entrySet()) {
            result.append(pair.getKey().getSimpleName())
                    .append("=")
                    .append(pair.getValue())
                    .append(",");
        }
        result.delete(result.length() - 2, result.length())
                .append("}");
        return result.toString();
    }
}
