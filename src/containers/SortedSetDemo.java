package containers;

import java.util.Collections;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/8/25
 **/
public class SortedSetDemo {
    public static void main(String[] args) {
        SortedSet<String> sortedSet = new TreeSet<>();
        Collections.addAll(sortedSet, "one two three four five six seven eight".split(" "));
        System.out.println(sortedSet);

        String low = sortedSet.first();
        String high = sortedSet.last();
        System.out.println(low);
        System.out.println(high);

        Iterator<String> it = sortedSet.iterator();
        for (int i = 0; i <= 6; i++) {
            if (i == 3) {
                low = it.next();
            }
            if (i == 6) {
                high = it.next();
            } else {
                System.out.println("i: " + i + it.next());
            }
        }
        System.out.println(low);
        System.out.println(high);

        System.out.println(sortedSet.subSet(low, high));
        //小于
        System.out.println(sortedSet.headSet(high));
        //大于或等于
        System.out.println(sortedSet.tailSet(low));
    }
}
