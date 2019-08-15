package containers;

import java.util.*;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/8/15
 **/
public class Unsupported {
    static void test(String msg, List<String> list) {
        System.out.println("--- " + msg + " ---");
        Collection<String> c = list;
        Collection<String> subList = list.subList(1, 8);
        Collection<String> c2 = new ArrayList<>(subList);
        try {
            c.removeAll(c2);
        } catch (Exception e) {
            System.out.println("retainAll(): " + e);
        }

        try {
            list.set(0, "X");
        } catch (Exception e) {
            System.out.println("List.set(): " + e);
        }
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("A B C D E F G H I J K L".split(" "));
        test("Modifiable Copy", new ArrayList<>(list));
        test("Arrays.asList()", list);
        //不可修改列表
        test("unmodifiableList()", Collections.unmodifiableList(new ArrayList<>(list)));
    }
}
