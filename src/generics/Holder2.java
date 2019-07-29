package generics;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/26
 **/
public class Holder2 {
    private Object a;

    public Holder2(Object a) {
        this.a = a;
    }

    public void set(Object a) {
        this.a = a;
    }

    public Object getA() {
        return a;
    }

    public static void main(String[] args) {
        Holder2 h2 = new Holder2(new Automobile());
        h2.set("Not an Automobile");
        String s = (String) h2.getA();
        h2.set(1);
        Integer x = (Integer) h2.getA();
    }
}
