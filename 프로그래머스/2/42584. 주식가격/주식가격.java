import java.util.*;

class Solution {
    public Queue<Integer> solution(int[] prices) {
        Queue<Integer> answer = new LinkedList<>();
        Queue<Integer> q = new LinkedList<>();
    
        // 1.prices 를 큐에 담는다.
        for (int x : prices){
            q.offer(x);
        }
        
        // 2.큐의 첫 원소를 꺼내고 큐가 빈값일 때까지 큐의 길이만큼 돌면서 큐의 원소를 차례로 꺼낸다.
        while (q.size() > 1){
            int tmp = q.poll();
            int res = 0;
            for (int x : q){
                // 3.비교할 때 마다 첫 원소보다 같거나 크다면 answer 변수에 +1 을 누적한다
                if (tmp <= x){
                    res++;
                // 4.더 작다면 answer 변수에 +1 을 누적하고 끝낸다.
                } else if (tmp > x){
                    res++;
                    break;
                }
            }
            answer.offer(res);
        }
        answer.offer(0);
        
        return answer;
    }
}