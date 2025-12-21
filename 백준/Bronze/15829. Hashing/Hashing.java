import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();

        long pow = 1;
        int m = 1234567891;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            int num = (int) c - 96;
            sum += (num * pow) % m;
            pow = 31 * pow % m;

        }
        System.out.println(sum%m);
    }
}
