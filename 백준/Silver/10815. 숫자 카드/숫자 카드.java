import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr1 = new int[n];
        String line1 = br.readLine();
        StringTokenizer st = new StringTokenizer(line1);
        for (int i = 0; i < n; i++){
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] arr2 = new int[m];
        String line2 = br.readLine();
        st = new StringTokenizer(line2);
        for (int i = 0; i < m; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }


        LinkedHashMap<Integer,Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < m; i++) {
            map.put(arr2[i],0);
        }
        for (int i = 0; i < n; i++) {
            if (map.get(arr1[i]) != null) {
                int v = map.get(arr1[i]);
                map.put(arr1[i],v+1);
            }
        }

        int[] answer = new int[m];
        int idx = 0;
        for (Map.Entry<Integer,Integer> x : map.entrySet()){
            answer[idx] = x.getValue();
            idx++;
        }

        StringBuilder sb = new StringBuilder();
        for (int x : answer) {
            sb.append(x +" ");
        }
        System.out.println(sb.toString().stripTrailing());
    }
}
