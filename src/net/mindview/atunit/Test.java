package net.mindview.atunit;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @description: 注解(也被称为元数据)为我们在代码中添加信息提供了一种形式化的方法，使我们可以在稍后某个时刻非常方便地使用这些数据
 * @author: YF.Mao
 * @create: 2019/8/27
 **/

/**
 * @Target 用来定义注解将应用于什么地方
 * @Retention 用来定义该注解在哪一个级别可用，在源代码中( SOURCE )、类文件中( CLASS )或者运行时( RUNTIME )
 *
 * 没有元素的注解称为标记注解
 *
 */
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Test {
}
