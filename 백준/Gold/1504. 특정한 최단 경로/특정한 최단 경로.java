
import java.io.*;
import java.util.*;

//다익스트라 응용
//1 ~ N 까지의 최단거리 도증 필수 경유지가 있는 경우
public class Main {

    static int INF = 200000000;
    static int n,m,v1,v2;
    static ArrayList<ArrayList<Edge>> graph;
    static int answer = 0;

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


    public static int[] dijkstra(int v) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(v,0));

        int[] dis = new int[n+1];
        Arrays.fill(dis,INF);
        dis[v] = 0;

        while (!pq.isEmpty()) {
            Edge tmp = pq.poll();
            int now = tmp.vex;
            int nowCost = tmp.cost;
            if (nowCost > dis[now]) continue;
            for (Edge ob : graph.get(now)) {
                if (dis[ob.vex] > nowCost + ob.cost) {
                    dis[ob.vex] = nowCost + ob.cost;
                    pq.offer(new Edge(ob.vex, dis[ob.vex]));
                    }
                }
            }
        return dis;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Edge(b,c));
            graph.get(b).add(new Edge(a,c));
        }
        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        //1 -> v1, 1 -> v2 거리 계산
        int[] dist1 = dijkstra(1);

        //v1 -> v2, v1 -> n
        int[] distV1 = dijkstra(v1);
        //v2 -> n (양방향이므로 v2 -> v1 == v1 -> v2)
        int[] distV2 = dijkstra(v2);

        
        //방문하는 순서가 다르기때문에 두개를 비교해서 최단경로 값을 찾아야함
        // 경로 1: 1 -> v1 -> v2 -> N
        long path1 = (long)dist1[v1] + distV1[v2] + distV2[n];

        // 경로 2: 1 -> v2 -> v1 -> N
        long path2 = (long)dist1[v2] + distV2[v1] + distV1[n];

        long answer = Math.min(path1, path2);

        if (answer >= INF) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }


    }
}

