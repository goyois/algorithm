import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long sum = factorial(n);
        System.out.println(sum);
        
    }
    
    static long factorial(int n){
        if (n <= 1) return 1;
        else return n * factorial(n-1);
    }
}