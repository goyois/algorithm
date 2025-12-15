import java.io.*;
import java.util.*;

public class Main {

    public static int gcd (int a, int b) {
        if (b == 0) {
            return a;
        } return gcd(b,a % b);
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        int c = gcd(a,b);
        System.out.println(c);
        System.out.println(a * b / c);

    }
}
