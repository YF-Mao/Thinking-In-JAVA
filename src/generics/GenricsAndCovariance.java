package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/29
 **/
public class GenricsAndCovariance {
    public static void main(String[] args) {
        //wrong
        //List<Fruit> flist = new ArrayList<Apple>();
        List<? extends Fruit> flist = new ArrayList<Apple>();
        //flist.add(new Orange());
        //flist.add(new Apple());
    }
}
