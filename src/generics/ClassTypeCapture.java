package generics;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/29
 **/
public class ClassTypeCapture<T> {
    Class<T> type;

    public ClassTypeCapture(Class<T> type) {
        this.type = type;
    }

    public boolean f(Object arg) {
        return type.isInstance(arg);
    }

    public <P> boolean g(P p) {
        return type.isInstance(p);
    }

    public static void main(String[] args) {
        ClassTypeCapture<Building> ctt1 = new ClassTypeCapture<>(Building.class);
        System.out.println(ctt1.f(new Building()));
        System.out.println(ctt1.g(""));
        System.out.println(ctt1.f(new House()));
        System.out.println(ctt1.g(new Integer("1")));
    }
}

class Building {

}

class House extends Building {

}
