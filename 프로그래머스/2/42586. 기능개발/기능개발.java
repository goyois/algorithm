import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        LinkedHashMap<Integer,Integer> map = new LinkedHashMap<>();
        Queue<Integer> pq = new LinkedList<>();
        Queue<Integer> sq = new LinkedList<>();
        for (int x : progresses) {
            pq.offer(x);
        }
        for (int x : speeds) {
            sq.offer(x);
        }

        int fp = pq.poll();
        int fs = sq.poll();
        int day = 0;
        for (int i = fp; i < 100; i = i + fs) {
            day++;
        }
        map.put(day,1);

        for (int x : sq) {
            int prog = pq.poll();
            int tmp = 0;
            for (int i = prog; i < 100; i = i + x) {
                tmp++;
            }
            if (day >= tmp) {
                map.put(day, map.get(day) + 1);
            } else {
                map.put(tmp,1);
                day = tmp;
            }
        }

        int[] answer = new int[map.size()];
        int idx = 0;
        for (Map.Entry<Integer, Integer> x : map.entrySet()) {
            answer[idx] = x.getValue();
            idx++;
        }
        return answer;
    }
}