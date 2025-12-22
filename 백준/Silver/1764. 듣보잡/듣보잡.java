
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            set.add(s);
        }
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            list.add(br.readLine());
        }


        int cnt = 0;
        ArrayList<String> answer = new ArrayList<>();
        for (String s : list) {
            if (set.contains(s)) {
                cnt++;
                answer.add(s);
            }
        }
        Collections.sort(answer);

        StringBuilder sb = new StringBuilder();
        sb.append(cnt+"\n");

        for (String x : answer) {
            sb.append(x+"\n");
        }

        System.out.println(sb.toString().stripTrailing());
    }
}
