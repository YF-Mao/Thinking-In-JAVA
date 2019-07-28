package generics;

import generics.coffee.Coffee;

import java.util.*;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/27
 **/
public class LimitsOfInterface {
    static <K, V> Map<K, V> f() {
        return new HashMap<>();
    }

    static Map j() {
        return new HashMap<>();
    }

    static void g(Map<Coffee, List<? extends Coffee>> map) {

    }

    public static void main(String[] args) {
        Map<String, Integer> test = f();
        test.put("sss", 1);
        System.out.println(test);

        Map<String, Integer> test1 = j();
        Map<String, Integer> test2 = new HashMap<>();

        Map<Coffee, List<? extends Coffee>> map = f();

        g(map);
    }
}
