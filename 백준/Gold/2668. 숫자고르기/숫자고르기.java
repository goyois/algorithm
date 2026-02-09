import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {


    //전역 변수 answer,arr,ch,finished
    static int[] arr;
    static boolean[] ch,finished;
    static ArrayList<Integer> list = new ArrayList<>();


    public static void dfs(int curr) {
        ch[curr] = true;
        int next = arr[curr];

        //1
        //curr = 1
        //next = 3

        //2
        //curr = 3
        //next = 1

        if (!ch[next]) {
            dfs(next);
        } else {
            if (!finished[next]) {
                list.add(curr); // 3,5 삽입
                //5의 경우 자기 자신이므로 ch 체크 후 finished 확정을 위해 넘어옴
                for (int tmp = next; tmp != curr; tmp = arr[tmp]) {
                    list.add(tmp); //arr[3]의 1 삽입
                }
            }
        }
        finished[curr] = true;

    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        arr = new int[n+1];
        ch = new boolean[n+1];
        finished = new boolean[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= n; i++) {
            if (!ch[i]) dfs(i);
        }

        // 집합의 총 갯수, 오름차순 출력
        Collections.sort(list);

        sb.append(list.size()).append("\n");
        for (int x : list) {
            sb.append(x).append("\n");
        }

        System.out.println(sb);
    }
}
