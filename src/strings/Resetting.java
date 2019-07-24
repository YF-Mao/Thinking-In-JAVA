package strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/24
 **/
public class Resetting {
    public static Pattern pattern = Pattern.compile("[frb][aiu][gx]");

    public static void main(String[] args) {
        Matcher m = pattern.matcher("fix the rug with bags");
        while (m.find()) {
            System.out.print(m.group() + " ");
        }

        System.out.println();
        m.reset("fix the rig with rags");
        while (m.find()) {
            System.out.print(m.group() + " ");
        }
    }
}
