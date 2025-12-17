import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        int b = sc.nextInt();
        
        int res = 0;
        for(int i = 0; i < n.length(); i++){
            char c = n.charAt(i);
            int tmp;
            
            if (c >= '0' && c <= '9'){
            tmp = c - '0';
            } else { tmp = c - 'A' +10;
                   }
            res = res * b + tmp;
        }
        System.out.println(res);
    }
}