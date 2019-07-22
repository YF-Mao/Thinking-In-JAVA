package holding;

import java.util.*;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/8
 **/
public class AddingGroups {
    public static void main(String[] args) {
        Collection<Integer> collection = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        Integer[] moreInts = {6, 7, 8, 9, 10};
        collection.addAll(Arrays.asList(moreInts));
        Collections.addAll(collection, 11, 12, 13, 14, 15);
        Collections.addAll(collection, moreInts);
        List<Integer> list = Arrays.asList(16, 17, 18, 19, 20);
        list.set(1, 99);
        System.out.println(collection.toString());

        ((ArrayList) collection).set(16, 99);
        System.out.println("后来：");
        for (Integer integer : collection) {
            System.out.print(integer);
        }

        System.out.println("moreInts");
        for (Integer integer : moreInts) {
            System.out.print(integer);
        }
    }
}
