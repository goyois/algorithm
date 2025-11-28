import java.util.*;

class Solution {
    public Queue<Integer> solution(int[] prices) {
        Queue<Integer> answer = new LinkedList<>();
        Queue<Integer> q = new LinkedList<>();
    
        for (int x : prices){
            q.offer(x);
        }
                while (q.size() > 1){
            int tmp = q.poll();
            int res = 0;
            for (int x : q){
                if (tmp <= x){
                    res++;
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