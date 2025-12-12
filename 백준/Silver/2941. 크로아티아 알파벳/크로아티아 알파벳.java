import java.io.*;
import java.util.*;

//크로아티아 알파벳
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int cnt = 0;
        LinkedList<String> set = new LinkedList<>();
        set.add("dz=");
        set.add("lj");
        set.add("nj");
        set.add("c-");
        set.add("c=");
        set.add("d-");
        set.add("s=");
        set.add("z=");

        for (String x : set) {
            while (s.contains(x)) {
                s = s.replaceFirst(x,"@");
                cnt++;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (Character.isAlphabetic(s.charAt(i))) {
                cnt++;
            }
        }
        System.out.println(cnt);

    }
}
