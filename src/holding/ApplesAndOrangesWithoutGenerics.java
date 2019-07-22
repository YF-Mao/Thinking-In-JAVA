package holding;

import java.util.ArrayList;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/8
 **/
public class ApplesAndOrangesWithoutGenerics {
    public static void main(String[] args) {
        ArrayList apples = new ArrayList();
        for (int i = 0; i < 3; i++) {
            apples.add(new Apple());
        }
        apples.add(new Orange());
        for (int i = 0; i < apples.size(); i++) {
            ((Apple) apples.get(i)).getId();
        }
    }
}

class Apple {
    private static long counter;
    private final long id = counter++;

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return super.toString() + "----" + this.id;
    }
}

class Orange {

}


