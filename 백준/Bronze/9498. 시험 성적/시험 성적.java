import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int score = sc.nextInt();
        sc.close();

        System.out.print((score > 89) ? 'A' : (score > 79) ? 'B' : (score > 69) ? 'C' : (score > 59) ? 'D' : 'F');
        
    }
}