package generics;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/27
 **/
public class GenericMethods {
    /**
     * 概念：
     * 1.可以在类中包含参数化方法，和这个方法所在的类是否是泛型类无关
     * 2.泛型方法使得该方法能够独立于类而产生变化
     * 例：如下中方法f()拥有类型参数，由该方法的返回类型前面的类型参数列表指明的
     * <p>
     * 准则
     * 1.只要你能做到，尽量使用泛型方法，如果可以取代整个类泛型化，就应该只使用泛型方法
     * 2.static方法需要使用泛型能力，就必须使其成为泛型方法
     */
    public <T> void f(T x) {
        System.out.println(x.getClass().getName());
    }

    public <K, V, T> void f(K k, V v, T t) {
        System.out.println(k.getClass().getName());
        System.out.println(v.getClass().getName());
        System.out.println(t.getClass().getName());
    }

    public static void main(String[] args) {
        GenericMethods gm = new GenericMethods();
        //编译器会自动找出相对应的类型，被称为类型参数推断
        gm.f("");
        gm.f("1");
        gm.f("1.0");
        gm.f("1.0f");
        gm.f('c');
        gm.f(gm);
    }
}
