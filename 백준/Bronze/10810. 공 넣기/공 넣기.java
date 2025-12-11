import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        int i,j,k;
        int[] arr = new int[n];
        for (int l = 0; l < m; l++) {
            i = sc.nextInt();
            j = sc.nextInt();
            k = sc.nextInt();
            for (int o = i-1; o <= j-1; o++) {
                arr[o] = k;
            }
        }
        for (int x : arr) {
            sb.append(x+" ");
        }
        System.out.println(sb.toString().stripTrailing());
    }
}
