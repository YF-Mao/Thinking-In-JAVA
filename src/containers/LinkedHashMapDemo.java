package containers;

import net.mindview.util.CountingMapData;

import java.util.LinkedHashMap;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/8/25
 **/
public class LinkedHashMapDemo {
    public static void main(String[] args) {
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>(new CountingMapData(9));
        System.out.println(linkedHashMap);

        //最近最少使用（LRU）算法
        //没有被访问过的元素就会出现在队列的签名（可能被看作需要删除的）
        linkedHashMap = new LinkedHashMap<>(16, 0.75f, true);
        linkedHashMap.putAll(new CountingMapData(9));
        System.out.println(linkedHashMap);

        for (int i = 0; i < 6; i++) {
            linkedHashMap.get(i);
        }
        System.out.println(linkedHashMap);
        linkedHashMap.get(0);
        System.out.println(linkedHashMap);
    }
}
