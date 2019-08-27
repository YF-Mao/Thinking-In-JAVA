package io.xfiles;

import io.Alien;

import java.io.*;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/8/26
 **/
public class ThawAlien {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File("X.file")));
        Alien mystery = (Alien) in.readObject();
        System.out.println(mystery.getClass());

        ObjectInputStream in1 = new ObjectInputStream(new FileInputStream(new File("..","X.file")));
        Object mystery1 =  in1.readObject();
        System.out.println(mystery1.getClass());
    }
}
