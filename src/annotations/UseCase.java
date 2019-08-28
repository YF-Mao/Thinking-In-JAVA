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

/**
 * @Target 可以用逗号分隔的形式指定多个值
 * 
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UseCase {
    /**
     * 注解元素可用的类型
     * 1.所有基本类型(int, float, boolean等)
     * 2.String
     * 3.Class
     * 4.enum
     * 5.Annotation
     * 6.以上类型的数组
     *
     *
     */
    int id();

    String description() default "no description";
}
