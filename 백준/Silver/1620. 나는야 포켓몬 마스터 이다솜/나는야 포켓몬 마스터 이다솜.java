import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<Integer,String> hm1 = new HashMap<>();
        HashMap<String,Integer> hm2 = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            String name = br.readLine();
            hm1.put(i,name);
            hm2.put(name,i);
        }


        StringBuilder sb = new StringBuilder();
        while (m-- > 0) {
            String name = br.readLine();
            char c = name.charAt(0);
            boolean isDigit = false;
            int idx = 0;

            if (Character.isDigit(c)) {
                isDigit = true;
                idx = Integer.parseInt(name);
            }
            if (isDigit) sb.append(hm1.get(idx)+"\n");
            if (!isDigit) sb.append(hm2.get(name)+"\n");

        }
        System.out.println(sb.toString().stripTrailing());
    }
}
