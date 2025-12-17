
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int dot = 2;
        int v = 1;
        for (int i = 0; i < n; i++) {
            dot += v;
            v *= 2;

        }
        System.out.println(dot*dot);
    }
}


