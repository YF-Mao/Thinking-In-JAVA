package generics;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/31
 **/
public class NeedCasting {
    @SuppressWarnings("unchecked")
    public void f(String[] args) throws Exception {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(args[0]));
        List<Widget> shapes = (List<Widget>) in.readObject();
    }

    public void g(String[] args) throws Exception {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(args[0]));
        //通过泛型类型来转型
        List<Widget> shapes = List.class.cast(in.readObject());
    }
}
