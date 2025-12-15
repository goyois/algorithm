
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[n+1];
        StringBuilder sb = new StringBuilder();

        //아리토스테네스의 체 풀이
        //만약 입력이 2보다 작을 경우 입력값전까지 배열 초기화   
        if (m > 2) {
            for (int k = 2; k < m; k++) {
                if (arr[k] == 0){
                    for (int l = k; l <= n; l = l+k) {
                        arr[l] = 1;
                    }
                }
            }
        }
        // 입력값 1 의 경우 건너뜀
        // i 를 +1 씩 순회하며 i 의 배수를 지워줌
        for (int i = m; i <= n; i++) {
            if (i == 1) continue;
            if (arr[i] == 0) {
                sb.append(i + "\n");
                for (int j = i; j <= n; j = j+i) {
                    arr[j] = 1;
                }
            }
        }
        System.out.println(sb.toString().stripTrailing());
    }
}
