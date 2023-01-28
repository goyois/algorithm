import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); //더할 값의 총 갯수
        int arr[] = new int[n];  //arr라는 배열은 입력되는 n의 크기를 가진다.

        StringTokenizer st;

        for (int i = 1; i <= arr.length; i++) {
                bw.write("Case #" + i + ": ");
                st = new StringTokenizer(br.readLine());
                bw.write(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()) + "\n");
        }
        br.close();

        bw.flush();
        bw.close();
    }
}
