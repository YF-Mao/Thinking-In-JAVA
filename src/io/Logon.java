package io;

import java.io.*;
import java.util.Date;

/**
 * @description: transient (瞬时)关键字，申明变量不需要进行序列化
 * @author: YF.Mao
 * @create: 2019/8/27
 **/
public class Logon implements Serializable {
    private Date date = new Date();
    private String username;
    private transient String password;

    public Logon(String name, String pwd) {
        username = name;
        password = pwd;
    }

    @Override
    public String toString() {
        return "Logon info: \n  username: " + username +
                "\n date: " + date + "\n    password: " + password;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Logon a = new Logon("Hulk", "myLittlePony");
        System.out.println(a);

        ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("Logon.out"));
        o.writeObject(a);
        o.close();

        System.out.println("========================");
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("Logon.out"));
        System.out.println("Recovering object at " + new Date());
        a = (Logon) in.readObject();
        System.out.println(a);
    }
}
