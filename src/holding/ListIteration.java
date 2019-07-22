package holding;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/8
 **/
public class ListIteration {
    public static void main(String[] args) {
        List<Apple> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add(new Apple());
        }

        ListIterator it = list.listIterator();
        while (it.hasNext()) {
            System.out.println(it.next() + ",index: " + it.nextIndex() + ", " + it.previousIndex() + "; ");
        }
        while (it.hasPrevious()) {
            System.out.println(it.previous() + " ");
        }
    }
}
