package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/8/28
 **/

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SimulatingNull {
    /**
     * 非基本类型的元素，定义默认值时，不能以 null 作为其值\
     *
     */
    int id() default -1;

    String description() default "";
}
