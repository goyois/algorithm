
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());


        int cntA = 0;
        int cntB = 0;
        HashSet<Integer> setA = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < a; i++) {
            setA.add(Integer.parseInt(st.nextToken()));
        }

        HashSet<Integer> setB = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < b; i++) {
            setB.add(Integer.parseInt(st.nextToken()));
        }

        for (int x : setB) {
            if (setA.contains(x)) {
                cntA++;
            }
        }
        for (int x : setA) {
            if (setB.contains(x)) {
                cntB++;
            }
        }

        int res1 = setA.size() - cntA;
        int res2 = setB.size() - cntB;

        StringBuilder sb = new StringBuilder();
        sb.append(res1+res2);
        System.out.println(sb);

    }
}
