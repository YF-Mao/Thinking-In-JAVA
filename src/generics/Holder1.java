package generics;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/26
 **/
public class Holder1 {
    private Automobile a;

    public Holder1(Automobile a) {
        this.a = a;
    }

    Automobile get() {
        return a;
    }
}

class Automobile {

}
