
import java.io.*;
import java.util.*;

//연속합
//카데인 알고리즘 (최대 부분 배열의 합)
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int curr = arr[0];
        int answer = arr[0];
        for (int i = 1; i < n; i++) {
            //curr 를 각 요소마다 더 큰값으로 비교한다.
            //현재 선택값 vs 현재까지의 계산된 최댓값 + 현재 선택값 
            curr = Math.max(arr[i], curr + arr[i]);
            //최댓값 갱신
            answer = Math.max(curr,answer);
        }
        
        System.out.println(answer);
    }
}
