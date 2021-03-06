package bingguo.api.internal.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/9/21
 **/
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface BaseErrorField {

    /**
     * JSON属性映射名称
     */
    String value() default "";
}
