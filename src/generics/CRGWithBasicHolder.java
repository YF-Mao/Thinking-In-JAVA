package generics;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/31
 **/
public class CRGWithBasicHolder {
    public static void main(String[] args) {
        Subtype st1 = new Subtype(), st2 = new Subtype();
        st1.set(st2);
        Subtype st3 = st1.get();
        st3.set(st2);
        BasicHolder s = st3.get();
        s.f();
        st1.f();
    }
}


//被称为古怪的循环泛型
//自限定的参数 被要求与使用这个参数的类 具有相同的基类
//创建了一个新类，继承自一个泛型类型，这个泛型类型接受我的类的名字作为参数
class Subtype extends BasicHolder<Subtype> {

}
