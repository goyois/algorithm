import java.io.*;
import java.util.*;

//숫자 카드2
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<Integer,Integer> map = new LinkedHashMap<>();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(st.nextToken());
            map.put(k,map.getOrDefault(k,0)+1);
        }

        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int k = Integer.parseInt(st.nextToken());
            sb.append(map.getOrDefault(k,0)).append(" ");
        }
        System.out.println(sb.toString().stripTrailing());
    }
}
