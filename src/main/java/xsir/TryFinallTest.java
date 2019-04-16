package xsir;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author zhangcong
 * @date 2019/4/4
 */
public class TryFinallTest {

    public static void  main(String[] args){
        Scanner in = new Scanner(System.in);
        int nums = in.nextInt();
        List<String> inputs = new ArrayList<>();
        for (int i = 0; i < nums; i++) {
            inputs.add(in.next());
        }
        List<String> res = inputs.stream().flatMap(str -> {
            List<String> tmp = new ArrayList<>();
            int s = 0;
            while (s < str.length()) {
               String t = str.substring(s, Math.min(s + 8, str.length()));
               int len = t.length();
               if (len < 8) {
                   for (int j = 0; j < 8 - len; j++) {
                       t += '0';
                   }
               }
               tmp.add(t);
               s += 8;
            }
            return tmp.stream();
        }).sorted().collect(Collectors.toList());
        System.out.println(String.join(" ", res));
    }

}
