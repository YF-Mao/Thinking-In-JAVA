package net.mindview.util;

/**
 * @description: 生成器的方法，专门负责创建对象的类
 * @author: YF.Mao
 * @create: 2019/7/27
 **/
public interface Generator<T> {
    T next();
}
