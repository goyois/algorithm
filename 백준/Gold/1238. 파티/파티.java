
import java.util.*;
import java.io.*;

public class Main {

    static int n,m,x;
    static ArrayList<ArrayList<Edge>> graph;
    static ArrayList<ArrayList<Edge>> revGraph;

    static class Edge implements Comparable<Edge>{
        int vex,cost;

        Edge(int vex,int cost) {
            this.vex = vex;
            this.cost = cost;
        }
        //최솟값 우선순위 큐
        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.cost,o.cost);
        }
    }



    public static int[] BFS(ArrayList<ArrayList<Edge>> targetGraph,int v) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(v,0));

        int[] dis = new int[n+1];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[v] = 0;

        while (!pq.isEmpty()) {
            Edge tmp = pq.poll();
            int now = tmp.vex;
            int nowCost = tmp.cost;
            if (dis[now] < nowCost) continue;
            for (Edge ob : targetGraph.get(now)) {
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
        x = Integer.parseInt(st.nextToken());


        graph = new ArrayList<>();
        revGraph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            revGraph.add(new ArrayList<>());
        }


        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Edge(b,c));
            revGraph.get(b).add(new Edge(a,c));
        }

        int[] toX = new int[n+1];
        int[] fromX = new int[n+1];
        toX = BFS(revGraph,x);
        fromX = BFS(graph,x);

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            answer = Math.max(answer, toX[i] + fromX[i]);
        }
        sb.append(answer);
        System.out.print(sb);
    }
}
