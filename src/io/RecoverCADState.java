package io;

import javax.swing.text.Document;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/8/27
 **/
public class RecoverCADState {
    //TODO static 信息标记的变量是不会自动的去序列化的，只有自己动手去实现
    //而且反序列化的时候并不会去执行构造器，因为 Square 中的 Color 并没有变成1
    //且必须维护写入序列化文件和从该文件中读回的顺序

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("CADState.out"));
        List<Class<? extends Shape>> shapeTypes = (List<Class<? extends Shape>>) in.readObject();
        Line.deserializeStaticState(in);
        List<Shape> shapes = (List<Shape>) in.readObject();
        System.out.println(shapes);
    }
}
