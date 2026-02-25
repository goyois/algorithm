
import java.io.*;
import java.util.*;

//treeMap
//firstKey = 최소 key 값을 가진 객체 추출
//lastKey = 최대 key 값을 가진 객체 추출
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        //I n = 삽입
        //D 1 = 최댓값 삭제
        //D -1 = 최솟값 삭제
        while (n-- > 0) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();
            while (k-- > 0) {

                StringTokenizer st = new StringTokenizer(br.readLine());
                String cmd = st.nextToken();
                int x = Integer.parseInt(st.nextToken());

                if (cmd.equals("I")){
                    if (map.containsKey(x)) map.replace(x,map.get(x) + 1);
                    else map.put(x,1);
                }

                if (!map.isEmpty() && cmd.equals("D")) {
                    int key = (x == 1) ? map.lastKey() : map.firstKey();
                    int cnt = map.get(key);
                    if (cnt > 1) map.replace(key,cnt - 1);
                    else map.remove(key);
                }
            }

            if (map.isEmpty()) sb.append("EMPTY").append("\n");
            else sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
        }

        System.out.println(sb);
    }
}
