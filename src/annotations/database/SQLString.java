package annotations.database;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @description: 注意点：如果定义了名为 value 的元素，在应用该注解时是唯一需要赋值的元素，
 * 无需使用名-值的语法，直接给出 value 的值即可，如 Member.class
 * @author: YF.Mao
 * @create: 2019/8/28
 **/
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SQLString {
    int value() default 0;

    String name() default "";

    Constraints constraints() default @Constraints;
}
