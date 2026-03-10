
import java.io.*;
import java.util.*;

//옥상 정원 꾸미기
public class Main {

    static class Top {
        int h,s;
        public Top(int h, int s) {
            this.h = h;
            this.s = s;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Stack<Top> st = new Stack<>();
        st.push(new Top(arr[n-1],0));

        long answer = 0;
        for (int i = n-2; i >= 0; i--) {
            int cnt = 0;
            if (!st.isEmpty() && arr[i] > st.peek().h) {
                while (!st.isEmpty() && arr[i] > st.peek().h) {
                    cnt++;
                    Top t = st.pop();
                    if (t.s > 0) cnt += t.s;
                }
                st.push(new Top(arr[i], cnt));
                answer += cnt;
            } else st.push(new Top(arr[i], 0));
        }
        System.out.println(answer);
    }
}
