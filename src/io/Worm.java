package io;

import java.io.*;
import java.util.Objects;
import java.util.Random;

/**
 * @description: 序列化的使用
 * @author: YF.Mao
 * @create: 2019/8/26
 **/
public class Worm implements Serializable {
    private static Random random = new Random(47);
    private transient Data[] d = {
            new Data(random.nextInt(10)),
            new Data(random.nextInt(10)),
            new Data(random.nextInt(10))};
    private Data2[] d2 = {
            new Data2(random.nextInt(10)),
            new Data2(random.nextInt(10)),
            new Data2(random.nextInt(10))};
    private Worm next;
    private char c;

    public Worm(int i, char x) {
        System.out.println("Worm constructor: " + i);
        c = x;
        if (--i > 0) {
            next = new Worm(i, (char) (x + 1));
        }
    }

    public Worm() {
        System.out.println("Default constructor");
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(":");
        result.append(c).append("(");
        if (!Objects.isNull(d)) {
            for (Data dat : d) {
                result.append(dat);
            }
        } else {
            result.append("Data is null");
        }
        result.append(",data2:");

        for (Data2 dat : d2) {
            result.append(dat);
        }

        result.append(")");
        if (next != null) {
            result.append(next);
        }
        return result.toString();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("worm.out"));
            String s = (String) in.readObject();
            Worm w2 = (Worm) in.readObject();
            System.out.println(s + "w2 = " + w2);
        } catch (IOException e) {
            System.out.println("Can't find file!");
        } catch (ClassNotFoundException e) {
            System.out.println("Can't find class!");
        }

        Worm w = new Worm(6, 'a');
        System.out.println("w = " + w);
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("worm.out"));
        out.writeObject("Worm storage\n");
        out.writeObject(w);
        out.close();

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("worm.out"));
        String s = (String) in.readObject();
        Worm w2 = (Worm) in.readObject();
        System.out.println(s + "w2 = " + w2);

        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream out2 = new ObjectOutputStream(bout);
        out2.writeObject("Worm storage\n");
        out2.writeObject(w);
        out2.flush();

        ObjectInputStream in2 = new ObjectInputStream(new ByteArrayInputStream(bout.toByteArray()));
        s = (String) in2.readObject();
        Worm w3 = (Worm) in2.readObject();
        System.out.println(s + "w3 = " + w3);
    }
}

class Data {
    private int n;

    public Data(int n) {
        this.n = n;
    }

    @Override
    public String toString() {
        return Integer.toString(n);
    }
}

class Data2 implements Serializable {
    private int n;

    public Data2(int n) {
        this.n = n;
    }

    @Override
    public String toString() {
        return Integer.toString(n);
    }
}
