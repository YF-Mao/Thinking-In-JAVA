package containers;

import net.mindview.util.Countries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/8/14
 **/
public class CollectionMethods {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<>();
        c.addAll(Countries.names(6));
        c.add("ten");
        c.add("eleven");
        System.out.println(c);

        Object[] array = c.toArray();
        System.out.println(Arrays.toString(array));

        String[] copy = "testtesttest".split("");
        String[] strings = c.toArray(copy);
        System.out.println(Arrays.toString(strings));

        String[] str = c.toArray(new String[0]);
        System.out.println(Arrays.toString(str));

        System.out.println("Collections.max(c) = " + Collections.max(c));
        System.out.println("Collections.min(c) = " + Collections.min(c));
    }
}
