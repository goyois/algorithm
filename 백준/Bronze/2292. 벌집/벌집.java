import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // cnt가 1일 때 한 커풀은 m=1 pos=1 cnt1
        // cnt가 2일 때 한 커풀은 m=6 pos=7 cnt2
        // cnt가 3일 때 한 커풀은 m=12 pos=19 cnt3
        // cnt가 4일 때 한 커풀은 m=18 pos=37 cnt4
        // cnt가 5일 때 한 커풀은 m=24 pos=61 cnt5
        //... 육각형이므로 6씩 증가

        //1에서 61번으로 가려면?
        //pos < 61 이 참이라면 m = i*6; i++, cnt++ 증가한 뒤
        //cnt 로 최소 거리를 구할 수 있음

        int pos = 1;
        int cnt = 1;
        int i = 1;
        int m = 0;
            while (pos < n) {
                m = 6 * i;
                pos += m;
                cnt++;
                i++;
            }
        System.out.println(cnt);
        br.close();
    }
}
