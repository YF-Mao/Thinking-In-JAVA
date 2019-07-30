package generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/30
 **/
public class UnboundedWildcards1 {
    static List list1;
    static List<?> list2;
    static List<? extends Object> list3;
    static List<? extends Apple> list4;
    static List<? super Apple> list5;

    @SuppressWarnings("unchecked")
    static void assign1(List list) {
        list1 = list;
        list2 = list;
        list3 = list;
        list4 = list;
        list5 = list;
        //如果没有指定泛型类型，编译虽然通过了，但是运行会报错，因为放进去的时候是有要求的
        //list5.addAll(list);
    }

    static void assign2(List<?> list) {
        list1 = list;
        list2 = list;
        list3 = list;
        //list4 = list;
        //list5 = list;
    }

    static void assign3(List<? extends Object> list) {
        list1 = list;
        list2 = list;
        list3 = list;
        //list4 = list;
        //list5 = list;
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        assign1(Arrays.asList(1,2,3));
        //以下代码虽然能编译通过，但是运行会报错，因为实际存的是Integer类
        //assign1()方法用的是原生类型，而不是java的泛型，所以编译无法识别错误
        //Apple a = list4.get(0);
        System.out.println(list4.get(0));
        assign1(new ArrayList<Integer>());
        assign2(new ArrayList<Integer>());
        assign3(new ArrayList<Integer>());
        assign1(new ArrayList());
        assign2(new ArrayList());
        assign3(new ArrayList());

        List<?> wildList = new ArrayList<String>();
        assign1(wildList);
        assign2(wildList);
        assign3(wildList);
    }
}
