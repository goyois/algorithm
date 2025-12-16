import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int line = n*2-1;
        int cnt = 2 * n - 3;
        for (int i = 1; i <= line; i++) {
            if (i <= n) {
                for (int j = n - i; j > 0; j--) {
                    System.out.print(" ");
                }
                for (int k = 1; k <= 2 * i - 1; k++) {
                    System.out.print("*");
                }
            } else {
            for (int j = 1; j < i-n+1; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= cnt; k++) {
                System.out.print("*");
            }
            cnt -= 2;
            }
            System.out.println();
        }
    }
}
