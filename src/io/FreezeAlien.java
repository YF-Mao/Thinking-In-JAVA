package io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/8/26
 **/
public class FreezeAlien {
    public static void main(String[] args) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("X.file"));
        Alien quellek = new Alien();
        out.writeObject(quellek);
    }
}
