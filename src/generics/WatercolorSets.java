package generics;

import generics.watercolors.Watercolors;

import java.util.EnumSet;
import java.util.Set;

import static generics.watercolors.Watercolors.*;
import static net.mindview.util.Sets.*;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/28
 **/
public class WatercolorSets {
    public static void main(String[] args) {
        //通过引用 static 的包来使用类中的方法和变量，而不需要加类名
        Set<Watercolors> set1 = EnumSet.range(BRILLIANT_RED, VIRIDIAN_HUE);
        Set<Watercolors> set2 = EnumSet.range(CERULEAN_BLUE_HUE, BURNT_UMBER);
        System.out.println("set1: " + set1);
        System.out.println("set2: " + set2);

        System.out.println("union(set1, set2): " + union(set1, set2));
        Set<Watercolors> subset = intersection(set1, set2);
        System.out.println("intersection(set1, set2)： " + subset);
    }
}
