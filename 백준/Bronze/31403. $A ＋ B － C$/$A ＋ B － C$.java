import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c= sc.nextInt();

        String sa = String.valueOf(a);
        sa += String.valueOf(b);
        String ba = String.valueOf(c);
        
        int n1 = Integer.parseInt(sa);
        int n2 = Integer.parseInt(ba);

        sb.append((a+b)-c+"\n");
        sb.append(n1-n2);
        System.out.println(sb.toString());
    }
}
