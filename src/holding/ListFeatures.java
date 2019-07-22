package holding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/8
 **/
public class ListFeatures {
    public static void main(String[] args) {
        List<Apple> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add(new Apple());
        }

        System.out.println(list);

        list.retainAll(Arrays.asList(list.get(1)));
        System.out.println(list);
    }
}
