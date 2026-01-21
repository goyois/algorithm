import java.util.*;
import java.io.*;

class Main{
    
    static int n,m,s;
    static int[] dis;
    static ArrayList<ArrayList<Edge>> graph;
    
    
    //최소 힙으로 정렬된 edge 클래스
    static class Edge implements Comparable<Edge> {
        int vex;
        int cost;
        
        Edge(int vex,int cost){
            this.vex = vex;
            this.cost = cost;
        }
        @Override
        public int compareTo(Edge o){
            return this.cost - o.cost;
        }
    }
    
    
    
    //메인에서 호출하는 솔루션 함수
    public static void solution(int v){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(v,0));
        dis[v] = 0;
        
        while(!pq.isEmpty()){
            Edge tmp = pq.poll();   
            int now = tmp.vex;
            int nowCost = tmp.cost;
            for (Edge ob : graph.get(now)){
                if(nowCost > dis[now]) continue;
                if (dis[ob.vex] > ob.cost + nowCost){
                    dis[ob.vex] = ob.cost + nowCost;
                    pq.offer(new Edge(ob.vex, nowCost + ob.cost));
                }
            }
        }
    }
   
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(br.readLine());
        
        dis = new int[n+1];
        Arrays.fill(dis,Integer.MAX_VALUE);
        graph = new ArrayList<>();
                             
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        
        while(m-- > 0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Edge(b,c));
        }
        
        solution(s);
        
        for (int i = 1; i <= n; i++){
            if (dis[i] == Integer.MAX_VALUE) sb.append("INF").append("\n");
            else sb.append(dis[i]).append("\n");
        }
        System.out.print(sb);
        
    }
}