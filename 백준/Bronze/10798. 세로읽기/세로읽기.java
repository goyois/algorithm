
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        char[][] arr = new char[5][15];
        int max = Integer.MIN_VALUE;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            String str = sc.next();
            if (str.length() > max) max = str.length();
            for (int j = 0; j < str.length(); j++) {
                    arr[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < max; i++) {
            for (int j = 0; j < arr.length; j++) {
                char c = arr[j][i];
                if (c != 0) {
                    sb.append(c);
                }
            }
        }
        System.out.println(sb.toString());
    }
}
