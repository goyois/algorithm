import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        String str = sc.nextLine();
        
        String[] arr = str.split("");
        
        System.out.println(arr.length);
    }
}