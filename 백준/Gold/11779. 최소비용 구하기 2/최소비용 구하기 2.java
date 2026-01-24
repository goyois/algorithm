import java.io.*;
import java.util.*;

//다익스트라 + 역추적
public class Main {

    static int start,end;
    static int[] dis,parent;
    static ArrayList<ArrayList<Edge>> graph;


    static class Edge implements Comparable<Edge>{
        int vex,cost;
        Edge(int vex,int cost) {
            this.vex=vex;
            this.cost=cost;
        }
        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.cost,o.cost);
        }
    }



    public static void BFS(int v) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(v,0));
        dis[v] = 0;

        while (!pq.isEmpty()) {
            Edge tmp = pq.poll();

            int now = tmp.vex;
            int nowCost = tmp.cost;

            if (nowCost > dis[now]) continue;

            for (Edge ob : graph.get(now)) {
                if (dis[ob.vex] > nowCost + ob.cost) { //더 빠른 경로를 찾았는지 확인
                    dis[ob.vex] = nowCost + ob.cost;  //최단 거리 정보 갱신
                    parent[ob.vex] = now;             //도착한 곳(ob.vex)에 어디에서 왔는지 기록
                    pq.offer(new Edge(ob.vex,dis[ob.vex]));
                }
            }
        }
    }





    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        //각 지점별 최단 경로가 들어가는 배열
        dis = new int[n+1];
        Arrays.fill(dis,Integer.MAX_VALUE);

        //정점별 비용을 담는 그래프
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        //역추적 배열
        parent = new int[n+1];

        while (m-- > 0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Edge(b,c));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        BFS(start);

        Stack<Integer> path = new Stack<>();
        int curr = end;
        //역추적 트릭 (end = 5)
        //1.스택에 5를 넣고
        //배열에 5번쨰 원소 : 4 를 curr 로 갱신
        //2.스택에 4를 넣고
        //배열에 4번째 원소 : 1 을 curr 로 갱신
        //3.배열의 원소 중 0을 만나 종료
        //curr 를 갱신하며
        while (curr != 0) {
            path.push(curr);
            curr = parent[curr];
        }
        
        sb.append(dis[end]).append("\n");
        sb.append(path.size()).append("\n");
        while (!path.isEmpty()) {
            sb.append(path.pop()+ " ");
        }

        System.out.println(sb);
    }
}
