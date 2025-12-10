package algorithm.demo.baek.svr;

import java.io.*;
import java.util.*;

public class NumberCard {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr1 = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] arr2 = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

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
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer,Integer> x : map.entrySet()){
            sb.append(x.getValue() +" ");
        }
        bw.write(sb.toString().stripTrailing());
        bw.flush();
        bw.close();
    }
}
