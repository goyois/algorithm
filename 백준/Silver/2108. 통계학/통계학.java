import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        double tmp = 0;
        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(br.readLine());
            tmp += k;
            arr[i] = k;
        }
        
        StringBuilder sb = new StringBuilder();
        Arrays.sort(arr);
        for (int i = 0; i < 4; i++) {
            if (i == 0) {
                int sum = (int) Math.round(tmp/n);
                sb.append(sum+"\n");
            } else if (i == 1) {
                sb.append(arr[arr.length/2]+"\n");
            } else if (i == 2) {
                
                HashMap<Integer, Integer> map = new HashMap<>();
                for (int num : arr) {
                    map.put(num, map.getOrDefault(num, 0) + 1);
                }
                int maxCnt = 0;
                int mode = -1;
                ArrayList<Integer> list = new ArrayList<>();
                for (Map.Entry<Integer, Integer> m : map.entrySet()) {
                    int key = m.getKey();
                    int value = m.getValue();
                    if (value > maxCnt) {
                        maxCnt = value;
                        mode = key;
                    }
                }
                list.add(mode); //최우선 최빈값 1개 추출

                //최빈값이 여러개이지 탐색
                for (Map.Entry<Integer, Integer> m : map.entrySet()) {
                    if (mode != m.getKey() && maxCnt == m.getValue()) {
                        list.add(m.getKey());
                    }
                }
                if (list.size() > 1) {
                    Collections.sort(list);
                    mode = list.get(1);
                    sb.append(mode+"\n");
                } else sb.append(mode+"\n");
            } else {
                int min = arr[0];
                int max = arr[arr.length-1];
                sb.append(max-min);
            }
        }
        System.out.println(sb);
    }
}
