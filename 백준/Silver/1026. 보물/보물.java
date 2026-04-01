
import java.io.*;
import java.util.*;

import static java.lang.System.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> A = new ArrayList<>();
        ArrayList<Integer> B = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            if (i == 0) for (int j = 0; j < n; j++) A.add(Integer.parseInt(st.nextToken()));
            else for (int j = 0; j < n; j++) B.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(A);

        int answer = 0;
        while (!A.isEmpty()) {
            int max = Integer.MIN_VALUE;
            int idx = 0;
            for (int i = 0; i < B.size(); i++) {
                if (B.get(i) > max){
                    max = B.get(i);
                    idx = i;
                }
            }
            answer += A.get(0) * B.get(idx);
            A.remove(0);
            B.remove(idx);
        }
        out.println(answer);
    }
}
