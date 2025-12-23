
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String,String> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            String p = st.nextToken();
            map.put(s,p);
        }
        StringBuilder sb = new StringBuilder();
        while (m-- > 0) {
            String s = br.readLine();
            sb.append(map.get(s)+"\n");
        }
        System.out.println(sb.toString().stripTrailing());

    }
}
