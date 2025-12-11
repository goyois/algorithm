
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        s = s.toLowerCase();

        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }

        char c = ' ';
        int max = Integer.MIN_VALUE;
        for (Map.Entry<Character, Integer> hm : map.entrySet()) {
            char k = hm.getKey();
            int v = hm.getValue();
            if (v > max) {
                c = k;
                max = v;
            }
        }
        int cnt = 0;
        for (Map.Entry<Character, Integer> hm : map.entrySet()) {
            if (max == hm.getValue()) {
                cnt++;
            }
        }
        if (cnt >= 2) {
            System.out.println("?");
        } else System.out.println(Character.toUpperCase(c));

    }
}
