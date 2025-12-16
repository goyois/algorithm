import java.util.*;

public class Main {

    static int BC(int n, int k){
        if (k == 0 || n == k) {
            return 1;
        }
        return BC(n-1,k-1) + BC(n-1,k);
    }

    public static void main(String[] args)   {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        System.out.println(BC(n,k));
    }
}
