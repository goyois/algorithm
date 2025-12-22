
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        int index = s.indexOf("*");
        int sum = 0;
        for (int i = 0; i < 13; i++) {
            if (i == index) continue;
            if (i % 2 == 0) sum += s.charAt(i) - '0';
            else sum += (s.charAt(i) - '0') * 3;
        }

        for (int i = 0; i < 10; i++) {
            if (index % 2 == 0) {
                if ((sum + i) % 10 == 0) {
                    System.out.println(i);
                    break;
                }
            } else {
                if ((sum + 3 * i) % 10 == 0) {
                    System.out.println(i);
                    break;
                }
            }
        }
    }
}
