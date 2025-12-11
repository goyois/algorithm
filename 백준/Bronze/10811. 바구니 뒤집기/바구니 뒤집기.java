
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i+1;
        }

        StringBuilder sb = new StringBuilder();
        int l,j,tmp;
        for (int i = 0; i < m; i++) {
            l = sc.nextInt()-1;
            j = sc.nextInt()-1;
            for (int k = j; k > l; k--) {
                tmp = arr[l];
                arr[l++] = arr[k];
                arr[k] = tmp;
            }
        }
        for (int x : arr) {
            sb.append(x+" ");
        }
        System.out.println(sb.toString().stripTrailing());

    }
}
