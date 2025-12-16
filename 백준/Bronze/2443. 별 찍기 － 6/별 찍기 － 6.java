import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int cnt = 2 * n - 1;
        for (int i = 1; i <= n; i++) {

            for (int j = 1; j < i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= cnt; k++) {
                System.out.print("*");
            }
            cnt -= 2;
            System.out.println();
        }
    }
}