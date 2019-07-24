package typeinfo;

import java.util.HashMap;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/25
 **/
public class PetCount {
    static class PetCounter extends HashMap<String, Integer> {
        public void count(String type) {
            Integer quantity = get(type);
            if (quantity == null) {
                put(type, 1);
            } else {
                put(type, quantity + 1);
            }
        }
    }
}
