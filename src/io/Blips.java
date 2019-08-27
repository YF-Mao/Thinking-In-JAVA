package io;

import java.io.*;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/8/26
 **/
public class Blips {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Constructor objects");
        Blip1 b1 = new Blip1(1);
        Blip1 b3 = new Blip1();
        Blip2 b2 = new Blip2();

        ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("Blips.out"));
        System.out.println("Saving objects:");
        o.writeObject(b1);
        o.writeObject(b3);
        o.writeObject(b2);
        o.close();

        System.out.println("====================");
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("Blips.out"));
        System.out.println("Recovering b1:");
        b1 = (Blip1) in.readObject();

        b3 = (Blip1) in.readObject();

        //读取会导致异常，因为 Blip2 的构造器不是公共的
        //System.out.println("Recovering b2:");
        //b2 = (Blip2) in.readObject();
    }
}

/**
 * Serializable 对象完全以它存储的二进制为基础来构造
 * Externalizable 对象对于所有普通的默认构造器都会被调用
 *
 */
class Blip1 implements Externalizable {
    public Blip1() {
        System.out.println("Blip1 Constructor");
    }

    public Blip1(int i) {
        System.out.println(i + "  test");
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("Blip1.writeExternal");
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("Blip1.readExternal");
    }
}

class Blip2 implements Externalizable {
    Blip2() {
        System.out.println("Blip2 Constructor");
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("Blip2.writeExternal");
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("Blip2.readExternal");
    }
}
