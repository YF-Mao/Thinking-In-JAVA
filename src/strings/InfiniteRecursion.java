package strings;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/22
 **/
public class InfiniteRecursion {
    @Override
    public String toString() {
        /**
         * 这里发生了自动类型转换，this会调用类本身的toString()方法，造成递归的异常
         *
         */
        return " InfiniteRecursion address: " + super.toString() + "\n";
    }

    public static void main(String[] args) {
        List<InfiniteRecursion> v = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            v.add(new InfiniteRecursion());
        }

        System.out.println(v);
    }
}
