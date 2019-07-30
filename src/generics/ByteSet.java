package generics;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/30
 **/
public class ByteSet {
    static Byte[] possibles = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    static Set<Byte> mySet = new HashSet<>(Arrays.asList(possibles));
    //you can't do this
    //Set<Byte> mySet2 = new HashSet<>(Arrays.<Byte>asList(1, 2, 3, 4, 5, 6, 7));

    public static void main(String[] args) {
        System.out.println(mySet);
    }
}
