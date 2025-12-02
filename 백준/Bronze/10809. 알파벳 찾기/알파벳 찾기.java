import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        StringBuilder sb = new StringBuilder();
        int idx = 97;
        for (int i = 1; i <= 26; i++) {
            char c = (char) idx;
            idx++;
            sb.append(s.indexOf(c)+" ");
        }
        System.out.println(sb.toString());
    }
}
