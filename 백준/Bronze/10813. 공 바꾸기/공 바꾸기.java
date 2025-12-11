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
        int i,j,tmp;
        for (int k = 0; k < m; k++) {
            i = sc.nextInt()-1;
            j = sc.nextInt()-1;
            tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
        for (int x : arr) {
            sb.append(x+" ");
        }
        System.out.println(sb.toString().stripTrailing());
    }
}
