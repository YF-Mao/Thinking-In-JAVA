package generics;

import java.util.Arrays;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/30
 **/
public class CaptureCaonversion {
    static <T> void f1(Holder<T> holder) {
        T t = holder.get();
        System.out.println(t.getClass().getSimpleName());
        System.out.println(Arrays.toString(holder.getClass().getTypeParameters()));
    }

    static void f2(Holder<?> holder) {
        f1(holder);
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Holder raw = new Holder<>(1);
        f2(raw);
        Holder rawBasic = new Holder();
        rawBasic.set(new Object());
        f2(rawBasic);
        Holder<?> wildcarded = new Holder<>(1.0);
        f2(wildcarded);
    }
}
