import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int X = sc.nextInt();
        int Y = sc.nextInt();
        sc.close();

        System.out.println((X > 0 ) && (Y > 0) ? "1" : (X < 0) && (Y < 0) ? "3" : (X > 0) && (Y < 0) ? "4" : "2");
    }
}