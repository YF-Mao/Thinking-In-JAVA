package arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/8/1
 **/
public class ArrayOfGenerics {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        //可以创建非泛型的数组，然后将其转型
        List<String>[] ls;
        List[] la = new List[10];
        ls = (List<String>[]) la;
        //ls = la;
        ls[0] = new ArrayList<>();
        //ls[1] = new ArrayList<Integer>();

        Object[] objects = la;
        objects[1] = new ArrayList<Integer>();
        List<BerylliumSphere>[] spheres = new List[10];
        for (int i = 0; i < spheres.length; i++) {
            spheres[i] = new ArrayList<>();
        }
    }
}
