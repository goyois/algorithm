
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] org = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            org[i] = x;
            set.add(x);
        }

        int[] srt = new int[set.size()];
        int idx = 0;
        for (int x : set) {
            srt[idx++] = x;
        }
        Arrays.sort(srt);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < org.length; i++) {
            int tmp = org[i];
            sb.append(Arrays.binarySearch(srt,tmp)+" ");
        }
        System.out.println(sb.toString().stripTrailing());
    }
}
