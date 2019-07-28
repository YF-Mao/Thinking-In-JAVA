package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/29
 **/
public class ListMaker<T> {
    List<T> create() {
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        ListMaker<String> stringListMaker = new ListMaker<>();
        List<String> stringList = stringListMaker.create();
    }
}
