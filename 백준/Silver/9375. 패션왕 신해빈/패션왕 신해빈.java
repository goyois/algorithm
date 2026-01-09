
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            HashMap<String,Integer> map = new HashMap<>();
            int n = sc.nextInt();
            while (n-- > 0) {
                sc.next();
                String s = sc.next();
                if (map.containsKey(s)) {
                    map.put(s, map.get(s) + 1);
                } else {
                    map.put(s,1);
                }
            }

            int res = 1;

            for (int v : map.values()) {
                res *= (v + 1);
            }
            System.out.println(res -1);
        }
    }
}
