
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        int[] arr = new int[n+1];
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 2; i <= n; i++) {
            if (arr[i] == 0) {
                if (i >= m){
                    sum += i;
                    if (i < min) {
                        min = i;
                    }
                }
                for (int j = i; j <= n; j = j + i) {
                    arr[j] = 1;
                }
            }
        }
        if (sum == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(min);
        }
    }
}
