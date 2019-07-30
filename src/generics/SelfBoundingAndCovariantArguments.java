package generics;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/31
 **/
public class SelfBoundingAndCovariantArguments {
    void testA(Setter s1, Setter s2, SelfBoundSetter selfBoundSetter, Setter1 setter1) {
        s1.set(s2);
        //error
        //因为自限定类型，编译器不能识别将基类型当做参数传递给set()的尝试
        //没有任何方法具有这样的签名，实际上。这个参数已经被覆盖了
        //s1.set(selfBoundSetter);
        //setter1.set(setter1);
        setter1.set(s1);
    }
}

interface SelfBoundSetter<T extends SelfBoundSetter<T>> {
    void set(T arg);
}

interface Setter extends SelfBoundSetter<Setter> {

}

interface Setter1 extends SelfBoundSetter<Setter> {

}
