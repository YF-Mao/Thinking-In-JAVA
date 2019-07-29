package generics;

import java.util.List;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/29
 **/
public class SuperTypeWildcards {
    /**
     * super: 超类型通配符  声明通配符是由某个特定类的任何基类来界定的
     *
     */
    static void writeTo(List<? super Apple> apples) {
        apples.add(new Apple());
        apples.add(new Jonathan());
        //apples.add(new Fruit());
    }
}
