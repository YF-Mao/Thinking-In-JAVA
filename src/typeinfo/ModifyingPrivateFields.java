package typeinfo;

import java.lang.reflect.Field;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/25
 **/
public class ModifyingPrivateFields {
    public static void main(String[] args) throws Exception {
        WithPirvateFinalField pf = new WithPirvateFinalField();
        System.out.println(pf);
        Field f = pf.getClass().getDeclaredField("i");
        f.setAccessible(true);
        System.out.println("f.getInt(pf): " + f.getInt(pf));
        f.setInt(pf, 47);

        System.out.println(pf);

        f = pf.getClass().getDeclaredField("s");
        f.setAccessible(true);
        System.out.println("f.get(pf): " + f.get(pf));
        f.set(pf, "No, you're not!");

        System.out.println(pf);
        f = pf.getClass().getDeclaredField("s2");
        f.setAccessible(true);
        System.out.println("f.get(pf): " + f.get(pf));
        f.set(pf, "No, you're not!");

        System.out.println(pf);
    }
}

class WithPirvateFinalField {
    /**
     * final域在遭遇修改时是安全的，运行时系统在不抛异常的情况下接受任何修改尝试，但是实际上不会发生任何修改
     *
     */
    private int i = 1;
    private final String s = "I'm totally safe";
    private String s2 = "Am I safe?";

    @Override
    public String toString() {
        return "i = " + i + ", " + s + ", " + s2;
    }
}
