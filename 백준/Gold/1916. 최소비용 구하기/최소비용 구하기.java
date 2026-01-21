import java.io.*;
import java.util.*;

public class Main {

    static int n,m,start,end;
    static int[] dis;
    static ArrayList<ArrayList<Edge>> graph;


    static class Edge implements Comparable<Edge>{
        int vex;
        int cost;

        Edge(int vex,int cost) {
            this.vex = vex;
            this.cost = cost;
        }
        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.cost,o.cost);
        }
    }


    public static void solution(int v) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        dis[v] = 0;
        pq.offer(new Edge(v,0));

        while (!pq.isEmpty()) {
            Edge tmp = pq.poll();
            int now = tmp.vex;
            int nowCost = tmp.cost;
            if (nowCost > dis[now]) continue;
            for (Edge ob : graph.get(now)) {
                if (dis[ob.vex] > nowCost + ob.cost) {
                    dis[ob.vex] = nowCost + ob.cost;
                    pq.offer(new Edge(ob.vex,nowCost+ob.cost));
                }
            }
        }
    }




    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        dis = new int[n+1];
        Arrays.fill(dis,Integer.MAX_VALUE);
        graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        while (m-- > 0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Edge(b,c));
        }

        st =  new StringTokenizer(br.readLine());

        start = Integer.parseInt(st.nextToken()); // 출발점
        end = Integer.parseInt(st.nextToken()); // 도착점

        solution(start);

        bw.write(String.valueOf(dis[end]));
        bw.flush();
        bw.close();

    }
}
