package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @description: 用来跟踪一个项目中的用例，如果一个方法或一组方法实现了某个用例的需求，可以添加。然后通过计算用例，来掌控项目的进展
 * 如果要更新或修改系统的业务逻辑，则也容易找到对应的用例
 * @author: YF.Mao
 * @create: 2019/8/27
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UseCase {
    int id();

    String description() default "no description";
}
