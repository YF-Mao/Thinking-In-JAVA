package strings;

import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/23
 **/
public class Groups {
    static public final String POEM = "" +
            "As we all know, attribute names conform to this pattern\n" +
            ",and other Java classes can discover and manipulate \n" +
            "the properties of these JavaBeans through their own mechanisms.\n" +
            "JavaBeans expose member properties to internal domains\n" +
            "by providing a common way to conform to a consistent design pattern.";

    /**
     * lookingAt(): 只有输入的最开始和正则匹配才会成功
     * matches(): 只有输入与正则完全匹配才成功
     *
     */
    public static Pattern pattern = Pattern.compile("(?m)(\\S+)\\s+((\\S+)\\s+(\\S+))$");

    public static void main(String[] args) throws UnsupportedEncodingException {
        Matcher m = pattern.matcher(POEM);
        //while (m.find()) {
        //    for (int j = 0; j <= m.groupCount(); j++) {
        //        System.out.print("[" + m.group(j) + "]");
        //    }
        //    System.out.println();
        //}
        System.out.println("-----------------------------------");
        StringBuffer s = new StringBuffer();
        while (m.find()) {
            m.appendReplacement(s, m.group().toUpperCase());
        }
        m.appendTail(s);
        System.out.println(s);
    }
}
