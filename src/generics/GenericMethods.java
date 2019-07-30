package generics;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/27
 **/
public class GenericMethods {
    /**
     * 泛型概念：
     * 1.可以在类中包含参数化方法，和这个方法所在的类是否是泛型类无关
     * 2.泛型方法使得该方法能够独立于类而产生变化
     * 例：如下中方法f()拥有类型参数，由该方法的返回类型前面的类型参数列表指明的
     * <p>
     * 准则
     * 1.只要你能做到，尽量使用泛型方法，如果可以取代整个类泛型化，就应该只使用泛型方法
     * 2.static方法需要使用泛型能力，就必须使其成为泛型方法
     *
     * <?> 表示无界通配符
     * 1.虽然编译器很少关心使用的是原生类型还是无界通配符，但是无界通配符声明了这里我是要用泛型来编写代码
     * ，可以将运行时错误转移到编译错误上去 示例：UnboundedWildcards1
     * 2.list 和 list<?>
     *
     *
     * super 表示下界，即表示T及其父类
     * extends 表示上界，即表示T及其子类
     * PECS原则
     * 如果要从集合中读取类型T的数据，并且不能写入，可以使用 ? extends 通配符；(Producer Extends)
     * 如果要从集合中写入类型T的数据，并且不需要读取，可以使用 ? super 通配符；(Consumer Super)
     * 如果既要存又要取，那么就不要使用任何通配符。
     *
     * 捕获转换只有在这样的情况下可以工作：即在方法内部，你需要使用确切的类型，
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
