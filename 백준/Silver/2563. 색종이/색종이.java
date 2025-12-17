import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();


        boolean[][] arr = new boolean[100][100];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            for (int j = a; j < a+10; j++) {
                for (int k = b; k < b+10; k++) {
                    if (!arr[j][k]) {
                        arr[j][k] = true;
                        sum++;
                    }
                }
            }
        }
        System.out.println(sum);
    }
}
