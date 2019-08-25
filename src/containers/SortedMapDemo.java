package containers;

import net.mindview.util.CountingMapData;

import java.util.Iterator;
import java.util.TreeMap;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/8/25
 **/
public class SortedMapDemo {
    public static void main(String[] args) {
        TreeMap<Integer, String> sortedMap = new TreeMap<>(new CountingMapData(10));
        System.out.println(sortedMap.keySet());
        System.out.println(sortedMap);
        Integer low = sortedMap.firstKey();
        Integer high = sortedMap.lastKey();
        System.out.println(low);
        System.out.println(high);
        Iterator<Integer> it = sortedMap.keySet().iterator();
        for (int i = 0; i <= 6; i++) {
            if (i == 3) {
                low = it.next();
            }
            if (i == 6) {
                high = it.next();
            } else {
                it.next();
            }
        }
        System.out.println(low);
        System.out.println(high);

        System.out.println(sortedMap.subMap(low, high));
        System.out.println(sortedMap.headMap(low));
        System.out.println(sortedMap.tailMap(high));
    }
}
