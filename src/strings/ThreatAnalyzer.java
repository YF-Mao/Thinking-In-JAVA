package strings;

import java.util.Scanner;
import java.util.regex.MatchResult;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/24
 **/
public class ThreatAnalyzer {
    static String threatData =
            "58.27.82.161@07/22/2019\n" +
                    "204.45.234.40@07/23/2019\n" +
                    "58.27.82.161@07/23/2019\n" +
                    "58.27.82.161@07/24/2019\n" +
                    "58.27.82.161@07/24/2019\n" +
                    "[Next log section with different data format]";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(threatData);
        String pattern = "(\\d+[.]\\d+[.]\\d+[.]\\d+)@" + "(\\d{2}/\\d{2}/\\d{4})";
        while (scanner.hasNext(pattern)) {
            scanner.next(pattern);
            MatchResult matchResult = scanner.match();
            String ip = matchResult.group(1);
            String date = matchResult.group(2);
            System.out.format("Threat on %s from %s\n", date, ip);
        }
    }

}
