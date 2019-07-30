package generics;

import java.util.List;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/31
 **/
public class UseList2<W, T> {
    void f1(List<T> v) {

    }

    void f2(List<W> v) {

    }

    //由于擦除的原因，当不能产生唯一的参数列表时，必须提供明显有区别的方法名
    //void f2(List<T> v) {
    //
    //}
}
