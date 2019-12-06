package io.mybatis;

import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.URL;
import java.util.Properties;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/9/17
 **/
public class Demo {
    public static void main(String[] args) throws IOException, ParserConfigurationException {
        //new Demo().test();
        //
        //String s = "classpath:mapper/**/*.xml";


        //System.out.println(s.substring(10));
        //StringBuffer stringBuffer = readURL();
        //System.out.println(stringBuffer.toString());

    }

    private void print() {
        double a = 1787.43;
        double b = 1.2350;
        double c = 1.2223;

        System.out.println(a * b);
        System.out.println(a * c);
        System.out.println(2207.48 - 22.70);
        System.out.println(1.0052 * 1.017);
        double expCost = 1.0223;
        double cost_30 = 1.0027;
        int price = 100;

        System.out.println((expCost - 1.0027) * 1718);

        System.out.println(price / cost_30);

        System.out.println(((10.0 / 1.0724) * (1.0724 - expCost) + (1.0 / 1.0979) * (1.0979 - expCost) +
                (1.0 / 1.0531) * (1.0531 - expCost) + (3.0 / 1.0482) * (1.0482 - expCost) +
                (2.0 / 1.0351) * (1.0351 - expCost) + (2.0 / 1.0285) * (1.0285 - expCost) + (2.0 / 1.0238) * (1.0238 - expCost) + (1.0 / 0.9963) * (0.9963 - expCost) + (5.0 / 0.9980) * (0.9980 - expCost))
                / ((expCost - cost_30) * 0.9988) * price * cost_30);

        System.out.println((10 / 1.0724 + 1 / 1.0979 + 1 / 1.0531 + 3 / 1.0482 + 2 / 1.0351 + 2 / 1.0285 + 2 / 1.0285 + 10 / 1.0027 + 1 / 0.9963 + 5 / 0.9980) * 100 * 0.9988);

        System.out.println((1.2455 - 1.2350) * 1787.43 + (0.8024 - 0.7969) * 2639.47 + (1.0345 - 1.0223) * 3582.12);
    }

    private void test() throws IOException {
        InputStream inputStream = new FileInputStream("application.properties");

        //XPathParser xPathParser = new XPathParser(inputStream);

        InputStream test = this.getClass().getClassLoader().getResourceAsStream("io/mybatis/application.properties");
        URL url = this.getClass().getClassLoader().getResource("io/mybatis/application.properties");
        //URL url1 = new URL(url.getPath());


        System.out.println("url.getFile() = " + url.getFile());
        System.out.println("url.getHost() = " + url.getHost());
        System.out.println("url.getPath() = " + url.getPath());

        Properties properties = new Properties();
        properties.load(test);
        System.out.println("getResourceAsStream: smtp.pwd = " + properties.getProperty("smtp.pwd"));

        properties.load(new FileInputStream(url.getFile()));
        System.out.println("getResource: smtp.account = " + properties.getProperty("smtp.account"));

        properties.load(inputStream);
        System.out.println("FileInputStream: smtp.pwd = " + properties.getProperty("smtp.pwd"));

        properties.load(url.openStream());
        System.out.println("url.openStream: smtp.pwd = " + properties.getProperty("smtp.pwd"));
    }

    public static StringBuffer readURL() throws IOException {
        String path = "https://mp.weixin.qq.com/s/pIZt0EA48n9Tob-KflPkIQ";
        //"https://mp.weixin.qq.com/s/bjxR7uW3AN9qOrZaDZ_nqg"
        InputStream inputStream = new BufferedInputStream(new URL(path).openStream());
        StringBuffer stringBuffer = new StringBuffer();
        byte[] b = new byte[1024 * 8];
        int len;
        while ((len = inputStream.read(b)) != -1) {
            stringBuffer.append(new String(b, 0, len, "UTF-8"));
        }
        inputStream.close();
        return stringBuffer;
    }
}