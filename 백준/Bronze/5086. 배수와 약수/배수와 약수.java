import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String s = "neither";
            int n = sc.nextInt();
            int m = sc.nextInt();
            if (n == 0 && m == 0) break;

            if (m % n == 0){
                s = "factor";
            } else {
                for (int i = 1; i <= n; i++) {
                    if (m * i == n) {
                        s = "multiple";
                    }
                }
            }
            System.out.println(s);
        }
    }
}
