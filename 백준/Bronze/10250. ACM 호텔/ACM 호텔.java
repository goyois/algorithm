
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        
        for(int i = 0; i < t; i++) {
            int h = in.nextInt();
            int w = in.nextInt();
            int n = in.nextInt();

            if(n % h == 0) {
                System.out.println((h * 100) + (n / h));
            } else {
                System.out.println(((n % h) * 100) + ((n / h) + 1));
            }
        }
    }
}
