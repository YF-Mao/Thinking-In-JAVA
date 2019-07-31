package typeinfo;

import typeinfo.pets.Pet;

import java.util.LinkedHashMap;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/25
 **/
public class PetCount3 {
    static class PetCounter extends LinkedHashMap<Class<? extends Pet>, Integer> {
        public PetCounter() {
            super();
        }
    }

    public static void main(String[] args) {
    }
}
