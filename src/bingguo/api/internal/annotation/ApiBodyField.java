package bingguo.api.internal.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/9/23
 **/
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiBodyField {

    /**
     * JSON属性映射名称
     *
     */
    String value() default "";


    /**
     * map字段名
     *
     */
    String fieldName() default "";
}
