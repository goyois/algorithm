import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int answer = n;
        if (answer == 0) {
            System.out.println(1);
            System.exit(0);
        }
        for (int i = n-1; i > 0; i--) {
            answer = answer*i;
        }
        System.out.println(answer);
    }
}
