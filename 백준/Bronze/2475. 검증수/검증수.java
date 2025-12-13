
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        
        int sum = 0;
        int tmp = 0;
        for (int i = 0; i < 5; i++) {
            tmp = Integer.parseInt(st.nextToken());
            sum += tmp * tmp;
        }
        System.out.println(sum % 10);
    }
}
