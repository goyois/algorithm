import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr1 = new int[n];
        int[] arr2 = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++){
            arr2[i] = Integer.parseInt(st.nextToken());
        }
        //투 포인터를 통해 배열을 병합할 때는 먼저 오름차순으로 정렬해야한다.
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        StringBuilder sb = new StringBuilder();
        //p1,p2 로 포인터를 잡는다.
        int p1 = 0; int p2 = 0;
        //인덱스 포인터가 입력 길이를 넘지 않을 때 실행된다.
        while (p1 < n && p2 < m) {
            if (arr1[p1] < arr2[p2]) {
                sb.append(arr1[p1++]+" ");
            } else sb.append(arr2[p2++]+ " ");
        }

        //어느 배열이 전부 false 인지 알 수 없으므로 두 배열 전부 반복문을 돌린다.
        while (p1 < n) {
            sb.append(arr1[p1++]+" ");
        }
        while (p2 < m) {
            sb.append(arr2[p2++]+" ");
        }
        System.out.println(sb.toString().stripTrailing());
    }
}
