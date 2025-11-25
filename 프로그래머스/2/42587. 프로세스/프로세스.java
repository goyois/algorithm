import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
    
    class Cons{
        private int priorities;
        private int location;

        public Cons(int priorities, int location) {
            this.priorities = priorities;
            this.location = location;
        }
    }
        
        int answer = 0;
        Queue<Cons> queue = new LinkedList<>();
        for (int i = 0; i< priorities.length; i++){
            queue.offer(new Cons(priorities[i],i));
        }

        while (!queue.isEmpty()) {
            Cons tmp = queue.poll();
            for (Cons x : queue) {
                if (tmp.priorities < x.priorities) {
                    queue.offer(tmp);
                    tmp = null;
                    break;
                }
            }
            if (tmp != null) {
                answer++;
                if (location == tmp.location) return answer;
            }
        }
        return answer;
    }
}