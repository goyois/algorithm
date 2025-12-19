import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            int n = Integer.parseInt(br.readLine());
            if (n == -1) break;

            StringBuilder sb = new StringBuilder();
            ArrayList<Integer> list = new ArrayList<>();
            int sum = 0;
            for (int i = 1; i <= n/2; i++) {
                if (n % i == 0) {
                    list.add(i);
                    sum+= i;
                }
            }

            if (sum == n){
                sb.append(n+" = ");
                for (int i = 0; i < list.size()-1; i++) {
                    sb.append(list.get(i)+ " + ");
                }
                int lastIndex = list.get(list.size()-1);
                sb.append(lastIndex);
                System.out.println(sb);
            } else{
                sb.append(n + " is NOT perfect.");
                System.out.println(sb);
            }
        }
    }
}
