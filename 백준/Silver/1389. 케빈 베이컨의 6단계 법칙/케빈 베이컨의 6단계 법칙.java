import java.io.*;
import java.util.*;

public class Main{
    
    static int max = 10000000;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[][] arr = new int[n+1][n+1];
        
        for(int i = 1; i <= n; i++){
            for (int j = 1; j <= n; j++){
                arr[i][j] = max; //최단 경로를 구해야하는 지점에 무한(큰 값) 값을 넣어줌
                if (i == j) arr[i][j] = 0; //자기 자신은 최단경로를 구하지않아도 됨 
            }
        }
        
        while (m-- > 0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = 1;
            arr[b][a] = 1; //양방향 처리
        }
        br.close();
        
        for(int k = 1; k <= n; k++){
            for(int i = 1; i <= n; i++){
                for (int j = 1; j <= n; j++){
                    //k 값을 경유 시 도달하는 값을 넣는다.
                    if (arr[i][j] > arr[i][k] + arr[k][j]){
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }
        
        int answer = Integer.MAX_VALUE;
        int idx = 0;
        
        //1행부터(1번 사람부터 최단 경로를 가진사람을 구한다.) 
        //j열을 순회하며 가장 min 값을 가진 i를 찾는다.
        for (int i = 1; i <= n; i++){
            int sum = 0;
            for (int j = 1; j <= n; j++){
                sum += arr[i][j];
            }
            
            if (answer > sum){
                answer = sum;
                idx = i;
            }
        }
        bw.write(String.valueOf(idx));
        bw.flush();
        bw.close();

    }
}