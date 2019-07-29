package generics;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/29
 **/
public class GenericHolder<T> {
    private T obj;

    public void set(T obj) {
        this.obj = obj;
    }

    public T get() {
        return obj;
    }

    public static void main(String[] args) {
        GenericHolder<String> holder = new GenericHolder<>();
        holder.set("Item");
        String s = holder.get();
        System.out.println(s);
    }
}
