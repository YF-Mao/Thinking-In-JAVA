package generics;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/30
 **/
public class Wildcards {
    /**
     * 因为是原生类型可以将任何类型的对象传递给set()，会放弃编译期检查
     * 接受所有Holder的不同变体
     * 
     */
    static void rawArgs(Holder holder, Object arg) {
        //warnings
        //holder.set(arg);
        Object obj = holder.get();
    }

    /**
     * 这个方法可以看出加了无界通配符，它将这些问题作为错误而不是警告报告了
     * 接受相同的所有类型
     *
     */
    static void unboundedArg(Holder<?> holder, Object arg) {
        //error
        //holder.set(arg);
        //holder.set(new Wildcards());

        Object obj = holder.get();
    }

    /**
     * 没有通配符，但是有额外的参数，所以编译器也会报错
     *
     */
    static <T> T exact1(Holder<T> holder) {
        return holder.get();
    }

    static <T> T exact2(Holder<T> holder, T arg) {
        holder.set(arg);
        return holder.get();
    }

    /**
     * 因为是T及其子类的，所以不能讲T放入其中
     * 但是可以调用get()方法
     *
     */
    static <T> T wildSubtype(Holder<? extends T> holder, T arg) {
        //error
        //holder.set(arg);
        return holder.get();
    }

    /**
     * 因为是T及其超类，所以不能拿到T类型，只能使用Object来接收
     * 但是可以使用set方法
     *
     */
    static <T> void wildSupertype(Holder<? super T> holder, T arg) {
        holder.set(arg);
        //error
        //T t = holder.get();
        Object obj = holder.get();
    }

    public static void main(String[] args) {
        Holder raw = new Holder();
        Holder<Long> qualified = new Holder<>();
        Holder<?> unbounded = new Holder<Long>();
        Holder<? extends Long> bounded = new Holder<>();

        Long lng = 1L;

        rawArgs(raw, lng);
        rawArgs(qualified, lng);
        rawArgs(unbounded, lng);
        rawArgs(bounded, lng);

        unboundedArg(raw, lng);
        unboundedArg(qualified, lng);
        unboundedArg(unbounded, lng);
        unboundedArg(bounded, lng);

        //warnings
        //Object r1 = exact1(raw);
        Long r2 = exact1(qualified);
        //must return Object
        Object r3 = exact1(unbounded);
        Long r4 = exact1(bounded);

        //warnings
        //Long r5 = exact2(raw, lng);
        Long r6 = exact2(qualified, lng);
        //error
        //Long r7 = exact2(unbounded, lng);
        //Long r8 = exact2(bounded, lng);
    }
}
