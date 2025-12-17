
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] arr = {25,10,5,1};

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int c = sc.nextInt();
            int tmp = 0;
            for (int j = 0; j < arr.length; j++) {
                tmp = c / arr[j];
                c -= tmp * arr[j];
                sb.append(tmp+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString().stripTrailing());
    }
}
